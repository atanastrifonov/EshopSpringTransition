package controllers.backoffice;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dto.CategoryData;
import dto.CategoryProductData;
import dto.ProductData;
import facade.capi.CategoryFacade;
import facade.capi.ProductFacade;
import forms.EditProductForm;

@Controller
@RequestMapping("/backoffice/products")
public class ProductsController {

	@Autowired
	CategoryFacade categoryFacade;

	@Autowired
	ProductFacade productFacade;

	@RequestMapping(method = GET)
	public String viewProductsLanding(Model model) {
		model.addAttribute("categories", categoryFacade.getAllCategories());
		return "admin/manageProductsLanding";
	}

	@RequestMapping(value = "/chooseCategory", method = GET)
	public String viewCategoryProducts(@RequestParam("categoryId") Short categoryId, Model model) {

		// get selected category and put it in the model for rendering purposes
		CategoryProductData selectedCategory = categoryFacade.getCategoryProductById(categoryId);
		model.addAttribute("selectedCategory", selectedCategory);

		return "admin/categoryProductsListing";
	}

	@RequestMapping(value = "/{productId}", method = GET)
	public String viewSingleProduct(@PathVariable("productId") int productId, HttpServletRequest request, Model model) {
		
		ProductData product = productFacade.getProductById(productId);
		EditProductForm editProductForm = new EditProductForm();
		editProductForm.setProductId(product.getId());
		editProductForm.setName(product.getName());
		editProductForm.setPrice(product.getPrice());
		editProductForm.setDescription(product.getDescription());
		editProductForm.setCategoryId(product.getCategoryId());

		model.addAttribute("editProductForm", editProductForm);
		
		List<CategoryData> categories = categoryFacade.getAllCategories();
		model.addAttribute("categories", categories);

		return "admin/editProduct";
	}
	
	@RequestMapping(value = "/editProduct", method = RequestMethod.POST)
	public String editSingleProduct(HttpServletRequest request, Model model,
			@ModelAttribute("editProductForm") @Valid EditProductForm editProductForm, Errors errors,
			RedirectAttributes redirectAttributes) {

		String returnURL = "redirect:/backoffice/products/" + editProductForm.getProductId();
		if (errors.hasErrors()) {
			redirectAttributes.addFlashAttribute("hasErrors", true);

			return returnURL;
		}

		ProductData productData = new ProductData();
		productData.setId(editProductForm.getProductId());
		productData.setName(editProductForm.getName());
		productData.setDescription(editProductForm.getDescription());
		productData.setLastUpdate(new Date());
		productData.setPrice(editProductForm.getPrice());
		productData.setCategoryId(editProductForm.getCategoryId());
		
		productFacade.updateProduct(productData);
		
		redirectAttributes.addFlashAttribute("isUpdateSuccessful", true);

		return returnURL;
	}
}

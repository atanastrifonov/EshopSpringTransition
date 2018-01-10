package controllers.backoffice;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dto.CategoryProductData;
import facade.capi.CategoryFacade;

@Controller
public class ProductsController {
	
	@Autowired
	CategoryFacade categoryFacade;
	
	@RequestMapping(value="/backoffice/products", method=GET)
	public String viewProductsLanding(Model model){
		model.addAttribute("categories", categoryFacade.getAllCategories());
		return "admin/manageProductsLanding";
	}
	
	@RequestMapping(value="/backoffice/products/chooseCategory", method=GET)
	public String viewCategoryProducts(@RequestParam("categoryId") Short categoryId, Model model){
		
        // get selected category and put it in the model for rendering purposes
        CategoryProductData selectedCategory = categoryFacade.getCategoryProductById(categoryId);
        model.addAttribute("selectedCategory", selectedCategory);
		
		return "admin/categoryProductsListing";
	}
	
	@RequestMapping(value = "/backoffice/products/{productId}", method = GET)
	public String viewSingleProduct(@PathVariable("productId") int productId, HttpServletRequest request, Model model) {
		return "admin/editProduct";
	}
}

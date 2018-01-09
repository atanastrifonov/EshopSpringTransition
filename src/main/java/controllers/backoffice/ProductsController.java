package controllers.backoffice;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@RequestMapping(value = "/{categoryId}", method = GET)
	public String viewCategoryProducts(@PathVariable("categoryId") int orderId, Model model){
		return "";
	}
}

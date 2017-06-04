package controllers;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import dto.CategoryProductData;
import facade.CategoryFacade;

@Controller
public class CategoryController {
	
	@Autowired
	CategoryFacade categoryFacade;
	
	@RequestMapping(value="/category/{categoryId}", method=GET)
	public String showCategory(@PathVariable("categoryId") Short categoryId, HttpServletRequest request, Model model){		
		 
        // get selected category and put it in the model for rendering purposes
        CategoryProductData selectedCategory = categoryFacade.getCategoryProductById(categoryId);
        model.addAttribute("selectedCategory", selectedCategory);
        
        // put the selected category URL in session for the language toggle functionality
        String selectedCategoryURL = "/category/" + selectedCategory.getId();
        request.getSession().setAttribute("selectedCategoryURL", selectedCategoryURL);
		
		return "category";
	}
}

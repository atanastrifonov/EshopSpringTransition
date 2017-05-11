package controllers;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

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
	public String showCategory(@PathVariable("categoryId") Short categoryId, Model model){		
		//Note: I may need to put the selectedCategory
		//into the session later - for the language toggle functionality
		 
        // get selected category
        CategoryProductData selectedCategory = categoryFacade.getCategoryProductById(categoryId);

        // place selected category in model (later in session)
        model.addAttribute("selectedCategory", selectedCategory);
		
		return "category";
	}
}

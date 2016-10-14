package controllers;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoryController {
	
	@RequestMapping(value="/category/{categoryId}", method=GET)
	public String showCategory(@PathVariable("categoryId") int categoryId, Model model){
		
		//TODO: get the selected category, put its products into the model
		
		//testing the path parameter
		model.addAttribute(categoryId);
		
		return "category";
	}
}

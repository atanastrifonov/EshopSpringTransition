package controllers;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import facade.CategoryFacade;

@Controller
public class HomeController {
	
	@Autowired
	CategoryFacade categoryFacade;
	
	@RequestMapping(value="/", method=GET)
	public String home(Model model){
		model.addAttribute("categories", categoryFacade.getCategories());
		
		return "home";
	}
}

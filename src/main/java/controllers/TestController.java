package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import repository.CategoryRepository;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class TestController {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@RequestMapping(value="/testController", method=GET)
	public String testPage(Model model){
		model.addAttribute("categories", categoryRepository.findAllCategories());
		
		return "testPage";
	}

}

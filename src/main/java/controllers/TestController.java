package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import repository.TestRepository;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class TestController {
	
	@Autowired
	TestRepository testRepository;
	
	@RequestMapping(value="/testController", method=GET)
	public String testPage(Model model){
		model.addAttribute("categories", testRepository.findAllCategories());
		
		return "testPage";
	}

}

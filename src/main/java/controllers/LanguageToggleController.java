package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LanguageToggleController {
	
	@RequestMapping(value="/chooseLanguage", method=RequestMethod.GET)
	public String chooseLanguage(@RequestParam("language") String language, Model model){
		model.addAttribute("language" ,language);
		
		return "testPage";
	}

}

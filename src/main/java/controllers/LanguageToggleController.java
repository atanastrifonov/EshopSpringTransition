package controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LanguageToggleController {

	@RequestMapping(value = "/chooseLanguage", method = RequestMethod.GET)
	public String chooseLanguage(@RequestParam("language") String language, HttpServletRequest request, Model model) {

		model.addAttribute("language", language);

		String userView = (String) request.getSession().getAttribute("view");

		if ((userView != null) && (!userView.equals("/index"))) {
			String forward = "forward:/" + userView;
			return forward;
		} else {
			return "home";
		}
	}

}

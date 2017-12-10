package controllers.backoffice;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BackofficeHomeController {
	
	@RequestMapping(value="/backoffice", method=GET)
	public String getHomePage(Model model){		
		return "admin/dashboard";
	}

}

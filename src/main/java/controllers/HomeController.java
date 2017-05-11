package controllers;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ServletContextAware;

import facade.CategoryFacade;

@Controller
public class HomeController implements ServletContextAware {
	
	@Autowired
	CategoryFacade categoryFacade;
	
	@RequestMapping(value="/", method=GET)
	public String home(Model model){		
		return "home";
	}

	/* 
	 * Setting up light category objects into the ServletContext
	 * during server startup
	 */
	@Override
	public void setServletContext(ServletContext servletContext) {
		servletContext.setAttribute("categories", categoryFacade.getCategories());		
	}
}

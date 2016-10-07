package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
public class TestController {
	
	@RequestMapping(value="/testController", method=GET)
	public String testPage(){
		return "testPage";
	}

}

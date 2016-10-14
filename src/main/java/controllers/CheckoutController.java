package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CheckoutController {

	@RequestMapping(value="/purchase", method=RequestMethod.POST)
	public String purchase(){
		if(Math.random() > 0.5f){
			return "confirmation";
		}else{
			return "checkout";
		}
		
	}
	
}

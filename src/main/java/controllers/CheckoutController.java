package controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cart.ShoppingCart;

@Controller
public class CheckoutController{
	
	// gets it from the servlet(app) context. More convenient than implementing ServletContextAware
	@Value("${deliverySurcharge}")
	private String surcharge;
	
	@RequestMapping(value="/checkout", method=RequestMethod.GET)
	public String checkout(HttpServletRequest request){
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
		cart.calculateTotal(surcharge);
		
		return "checkout";
	}

	@RequestMapping(value="/purchase", method=RequestMethod.POST)
	public String purchase(){
		if(Math.random() > 0.5f){
			return "confirmation";
		}else{
			return "checkout";
		}		
	}
}

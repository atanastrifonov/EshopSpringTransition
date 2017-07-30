package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cart.ShoppingCart;
import forms.CustomerDetailsForm;

@Controller
public class CheckoutController{
	
	// gets it from the servlet(app) context. More convenient than implementing ServletContextAware
	@Value("${deliverySurcharge}")
	private String surcharge;
	
	@RequestMapping(value="/checkout", method=RequestMethod.GET)
	public String checkout(HttpServletRequest request, Model model){
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
		cart.calculateTotal(surcharge);
		
		model.addAttribute("customerDetailsForm", new CustomerDetailsForm());
		
		return "checkout";
	}

	@RequestMapping(value="/purchase", method=RequestMethod.POST)
	public String purchase(Model model, @ModelAttribute("customerDetailsForm") @Valid CustomerDetailsForm customerDetailsForm, Errors errors){
		
		if(errors.hasErrors()){
			return "checkout";
		}
		
		model.addAttribute("name", customerDetailsForm.getName());
		model.addAttribute("email", customerDetailsForm.getEmail());
		model.addAttribute("address", customerDetailsForm.getAddress());
		model.addAttribute("ccNumber", customerDetailsForm.getCcNumber());
		model.addAttribute("phone", customerDetailsForm.getPhone());
		model.addAttribute("cityRegion", customerDetailsForm.getCityRegion());
		
		//REDIRECT it to confirmation later
		return "confirmation";
	}
}

package controllers;

import org.springframework.web.bind.annotation.RequestMethod;

import forms.ProductToCartForm;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CartController {
//kogato implementiram ShoppingCart -> str. 82 3.4.1 Session and Request scoping beans	
	@RequestMapping(value="/viewCart", method=RequestMethod.GET)
	public String viewCart (Model model){
		return "cart";
	}
	
	@RequestMapping(value="/addToCart", method=RequestMethod.POST)
	public String addToCart(@Valid ProductToCartForm productForm, Errors errors){
		return "";
	}
	
	@RequestMapping(value=("/updateCart"), method=RequestMethod.POST)
	public String updateCart(@Valid ProductToCartForm productForm, Errors errors){
		return "";
	}

}

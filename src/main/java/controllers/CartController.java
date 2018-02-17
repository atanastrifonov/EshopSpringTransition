package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cart.ShoppingCart;
import dto.ProductData;
import facade.capi.ProductFacade;
import forms.UpdateProductInCartForm;

@Controller
public class CartController {
	//kogato implementiram ShoppingCart -> str. 82 3.4.1 Session and Request scoping beans	
	
	@Autowired
	ProductFacade productFacade;
	
	@RequestMapping(value="/viewCart", method=RequestMethod.GET)
	public String viewCart (@RequestParam(required=false, name="clear") String clearCart, HttpServletRequest request, Model model){
        
		if ((clearCart != null) && clearCart.equals("true")) {
            ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
            cart.clear();
        }		
		return "cart";
	}
	
	@RequestMapping(value="/addToCart", method=RequestMethod.POST)
	public String addToCart(HttpServletRequest request, Model model){
		
		HttpSession session = request.getSession();
		ShoppingCart cart = (ShoppingCart)session.getAttribute("cart");
		
        // if user is adding item to cart for first time
        // create cart object and attach it to user session
        if (cart == null) {
            cart = new ShoppingCart();
            session.setAttribute("cart", cart);
        }

        // get user input from request
        String productId = request.getParameter("productId");

        if (!productId.isEmpty()) {

            ProductData productData = productFacade.getProductById(Integer.parseInt(productId));
            cart.addItem(productData);
        }
		
        String viewString = "redirect:" + session.getAttribute("view").toString();        
		return viewString;
	}
	
	@RequestMapping(value=("/updateCart"), method=RequestMethod.POST)
	public String updateCart(HttpServletRequest request, @Valid UpdateProductInCartForm productForm, Errors errors){
		
		if(errors.hasErrors()){
			//TODO: handle them
		}
		
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
		if(cart!=null){
			cart.update(productForm.getProductID(), productForm.getQuantity());
		}
		
		return "cart";
	}

}

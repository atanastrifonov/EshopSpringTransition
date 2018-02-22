package controllers;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cart.ShoppingCart;
import dto.CustomerData;
import facade.capi.OrderFacade;
import forms.CustomerDetailsForm;

@Controller
public class CheckoutController {
	
	@Autowired
	OrderFacade orderFacade;

	// gets it from the servlet(app) context. More convenient than implementing
	// ServletContextAware
	@Value("${deliverySurcharge}")
	private String surcharge;

	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public String checkout(HttpServletRequest request, Model model) {
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
		cart.calculateTotal(surcharge);

		model.addAttribute("customerDetailsForm", new CustomerDetailsForm());

		return "checkout";
	}

	//TODO: change the view forward to redirect... just in case.
	@RequestMapping(value = "/purchase", method = RequestMethod.POST)
	public String purchase(HttpServletRequest request, Model model,
			@ModelAttribute("customerDetailsForm") @Valid CustomerDetailsForm customerDetailsForm, Errors errors) {

		if (errors.hasErrors()) {
			return "checkout";
		}
		
		HttpSession session = request.getSession();
		
		ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");

		if (cart != null) {
			CustomerData.Builder customerDataBuilder = new CustomerData.Builder();
			CustomerData customerData = customerDataBuilder.setNestedName(customerDetailsForm.getName())
					.setNestedEmail(customerDetailsForm.getEmail())
					.setNestedAddress(customerDetailsForm.getAddress())
					.setNestedPhone(customerDetailsForm.getPhone())
					.setNestedCityRegion(customerDetailsForm.getCityRegion())
					.setNestedCCNumber(customerDetailsForm.getCcNumber())
					.build();
			
			int orderId = orderFacade.placeOrder(customerData, cart);
			
            // if order processed successfully send user to confirmation page
            if (orderId != 0) {

                // in case language was set using toggle, get language choice before destroying session
                Locale locale = (Locale) session.getAttribute("javax.servlet.jsp.jstl.fmt.locale.session");
                String language = "";

                if (locale != null) {

                    language = (String) locale.getLanguage();
                }

                // dissociate shopping cart from session
                cart = null;

                // end session
                session.invalidate();

                if (!language.isEmpty()) {                      // if user changed language using the toggle,
                                                                // reset the language attribute - otherwise
                    request.setAttribute("language", language); // language will be switched on confirmation page!
                }

                // get order details
                Map orderMap = orderFacade.getOrderDetails(orderId);

                // place order details in request scope
                model.addAttribute("customer", orderMap.get("customer"));
                model.addAttribute("lineItems", orderMap.get("lineItems"));
                model.addAttribute("orderRecord", orderMap.get("orderRecord"));
                model.addAttribute("orderedProducts", orderMap.get("orderedProducts"));

                return "confirmation";

            // otherwise, send back to checkout page and display error
            } else {
                model.addAttribute("orderFailureFlag", true);
                return "checkout";
            }
		}

		// REDIRECT it to home page if something weird is going on
		return "home";
	}
}

package controllers.backoffice;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import facade.capi.OrderFacade;
import forms.EditOrderForm;
import service.capi.EmailService;

@Controller
@RequestMapping("/backoffice/orders")
public class OrdersController {

	@Autowired
	OrderFacade orderFacade;
	
	@RequestMapping(value = "/pending", method = GET)
	public String viewPendingOrders(Model model) {
		model.addAttribute("pendingOrders", orderFacade.getAllPendingOrders());
		return "admin/pendingOrders";
	}

	@RequestMapping(value = "/{orderId}", method = GET)
	public String viewSingleOrder(@PathVariable("orderId") int orderId, HttpServletRequest request, Model model) {

		// get order details
		Map orderMap = orderFacade.getOrderDetails(orderId);

		// place order details in request scope
		model.addAttribute("customer", orderMap.get("customer"));
		model.addAttribute("products", orderMap.get("products"));
		model.addAttribute("orderRecord", orderMap.get("orderRecord"));
				
		// prepare the form
		model.addAttribute("editOrderForm", new EditOrderForm());

		return "admin/editOrder";
	}

	@RequestMapping(value = "/editOrder", method = RequestMethod.POST)
	public String editSingleOrder(HttpServletRequest request, Model model,
			@ModelAttribute("editOrderForm") @Valid EditOrderForm editOrderForm, Errors errors,
			RedirectAttributes redirectAttributes) {

		String returnURL = "redirect:/backoffice/orders/" + editOrderForm.getOrderId();

		if (errors.hasErrors()) {
			redirectAttributes.addFlashAttribute("hasErrors", true);

			return returnURL;
		}

		// TODO: think about optimization so that the updateOrder repository method can be saved from making an additional query
		// to the database for retrieving CustomerOrder's model
		orderFacade.updateOrder(editOrderForm.getOrderId(), editOrderForm.getStatus());
		
		redirectAttributes.addFlashAttribute("isUpdateSuccessful", true);

		return returnURL;
	}
}

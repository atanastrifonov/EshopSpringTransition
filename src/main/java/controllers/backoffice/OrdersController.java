package controllers.backoffice;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import facade.capi.OrderFacade;

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
	public String viewSingleOrder(@PathVariable("orderId") int orderId, Model model) {
		
        // get order details
        Map orderMap = orderFacade.getOrderDetails(orderId);

        // place order details in request scope
        model.addAttribute("customer", orderMap.get("customer"));
        model.addAttribute("products", orderMap.get("products"));
        model.addAttribute("orderRecord", orderMap.get("orderRecord"));
		
		return "admin/editOrder";
	}
}

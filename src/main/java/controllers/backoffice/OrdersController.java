package controllers.backoffice;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
}

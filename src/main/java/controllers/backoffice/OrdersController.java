package controllers.backoffice;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/backoffice/orders")
public class OrdersController {
	
	@RequestMapping(value="/pending", method=GET)
	public String viewPendingOrders(Model model){
		return "admin/pendingOrders";
	}
}

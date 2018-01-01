package controllers.backoffice;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EditOrderController {
	
	// TODO: Delete this one and put everything in OrdersController
	
	@RequestMapping(value = "/backoffice/orders/orderId", method = GET)
	public String viewOrder(Model model) {
		return "admin/editOrder";
	}

}

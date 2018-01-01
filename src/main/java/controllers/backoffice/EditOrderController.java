package controllers.backoffice;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EditOrderController {
	
	@RequestMapping(value = "/backoffice/orders/orderId", method = GET)
	public String viewOrder(Model model) {
		return "admin/editOrder";
	}

}

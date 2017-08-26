package facade.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cart.ShoppingCart;
import dto.CustomerData;
import facade.capi.OrderFacade;
import mappers.CustomerMapper;
import service.capi.OrderService;

@Component
public class DefaultOrderFacade implements OrderFacade {

	@Autowired
	OrderService orderService;

	@Override
	public int placeOrder(CustomerData customerData, ShoppingCart cart) {
		int orderId = orderService.placeOrder(CustomerMapper.mapSingle(customerData), cart);
		return orderId;
	}

	@Override
	public Map getOrderDetails(int orderId) {
		return orderService.getOrderDetails(orderId);
	}

}

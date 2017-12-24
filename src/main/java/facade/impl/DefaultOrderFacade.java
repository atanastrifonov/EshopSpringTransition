package facade.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cart.ShoppingCart;
import dto.CustomerData;
import dto.OrderData;
import entity.CustomerOrder;
import facade.capi.OrderFacade;
import mappers.CustomerMapper;
import mappers.OrderMapper;
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

	@Override
	public List<OrderData> getAllPendingOrders() {
		List<CustomerOrder> orderModels = orderService.getAllPendingOrders();
		return OrderMapper.mapCollection(orderModels);
	}

}

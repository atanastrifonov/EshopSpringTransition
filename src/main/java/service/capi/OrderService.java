package service.capi;

import java.util.Map;

import cart.ShoppingCart;
import entity.Customer;

public interface OrderService {
	public int placeOrder(Customer customer, ShoppingCart cart);
	public Map getOrderDetails(int orderId);
}

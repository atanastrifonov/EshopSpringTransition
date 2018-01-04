package service.capi;

import java.util.List;
import java.util.Map;

import cart.ShoppingCart;
import entity.Customer;
import entity.CustomerOrder;

public interface OrderService {
	public int placeOrder(Customer customer, ShoppingCart cart);
	public Map getOrderDetails(int orderId);
	public List<CustomerOrder> getAllPendingOrders();
	public void updateOrder(int orderId, String status);
}

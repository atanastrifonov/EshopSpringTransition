package facade.capi;

import java.util.List;
import java.util.Map;

import cart.ShoppingCart;
import dto.CustomerData;
import dto.OrderData;

public interface OrderFacade {
	public int placeOrder(CustomerData customerData, ShoppingCart cart);
	public Map getOrderDetails(int orderId);
	public List<OrderData> getAllPendingOrders();
	public void updateOrder(int orderId, String status);
}

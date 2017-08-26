package facade.capi;

import java.util.Map;

import cart.ShoppingCart;
import dto.CustomerData;

public interface OrderFacade {
	public int placeOrder(CustomerData customerData, ShoppingCart cart);
	public Map getOrderDetails(int orderId);
}

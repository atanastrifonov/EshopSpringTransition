package repository.capi;


import java.util.List;

import entity.CustomerOrder;

public interface CustomerOrderRepository {
	public void addOrder(CustomerOrder order);

	public CustomerOrder getOrderById(int orderId);
	
	public List<CustomerOrder> getAllPendingOrders();
}

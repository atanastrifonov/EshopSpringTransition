package repository.capi;

import entity.CustomerOrder;

public interface CustomerOrderRepository {
	public void addOrder(CustomerOrder order);

	public CustomerOrder getOrderById(int orderId);
}

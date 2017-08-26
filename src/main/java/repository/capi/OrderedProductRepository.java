package repository.capi;

import java.util.List;

import entity.OrderedProduct;

public interface OrderedProductRepository {
	public void addOrderedProduct(OrderedProduct orderedProduct);

	public List<OrderedProduct> findAllByOrderId(Object orderId);
}

package repository.capi;

import entity.Product;

public interface ProductRepository {
	public Product getProductById(Integer id);
}

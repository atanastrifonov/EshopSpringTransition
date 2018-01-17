package service.capi;

import entity.Product;

public interface ProductService {
	public Product getProductById(Integer id);
	public void updateProduct(Product productModel);
}

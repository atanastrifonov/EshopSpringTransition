package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import entity.Product;
import repository.capi.ProductRepository;
import service.capi.ProductService;

@Component
public class DefaultProductService implements ProductService{

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public Product getProductById(Integer id) {
		return productRepository.getProductById(id);
	}

	@Override
	public void updateProduct(Product productModel) {
		productRepository.updateProduct(productModel);
	}
}

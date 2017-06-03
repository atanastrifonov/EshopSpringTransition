package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import entity.Product;
import repository.ProductRepository;

@Component
public class DefaultProductService implements ProductService{

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public Product getProductById(Integer id) {
		return productRepository.getProductById(id);
	}

}

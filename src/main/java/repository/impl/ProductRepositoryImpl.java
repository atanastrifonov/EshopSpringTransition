package repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entity.Product;
import repository.capi.CategoryRepository;
import repository.capi.ProductRepository;

@Repository
@Transactional
public class ProductRepositoryImpl implements ProductRepository{
	
	@PersistenceContext
	private EntityManager em;
		
	@Override
	public Product getProductById(Integer id) {
		return em.find(Product.class, id);
	}

	@Override
	public void updateProduct(Product product) {
		em.merge(product);
	}
}

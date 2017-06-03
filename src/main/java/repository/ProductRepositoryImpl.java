package repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entity.Product;

@Repository
@Transactional
public class ProductRepositoryImpl implements ProductRepository{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Product getProductById(Integer id) {
		return em.find(Product.class, id);
	}

}

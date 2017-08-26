package repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entity.OrderedProduct;
import repository.capi.OrderedProductRepository;

@Repository
@Transactional
public class OrderedProductRepositoryImpl implements OrderedProductRepository {
	
	//consider using an already existing EntityManager instead of the proxy
	//as we I need to flush the Customer and Order records first!!! ( Spring may handle this though)
	@PersistenceContext
	private EntityManager em;

	@Override
	public void addOrderedProduct(OrderedProduct orderedProduct) {
		em.persist(orderedProduct);
	}

	@Override
	public List<OrderedProduct> findAllByOrderId(Object orderId) {
		return em.createNamedQuery("OrderedProduct.findByCustomerOrderId").setParameter("customerOrderId", orderId).getResultList();
	}

}

package repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import entity.CustomerOrder;
import repository.capi.CustomerOrderRepository;

@Repository
@Transactional
public class CustomerOrderRepositoryImpl implements CustomerOrderRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void addOrder(CustomerOrder order) {
		em.persist(order);
		em.flush();
	}

	@Override
	public CustomerOrder getOrderById(int orderId) {
		return em.find(CustomerOrder.class, orderId);
	}

}

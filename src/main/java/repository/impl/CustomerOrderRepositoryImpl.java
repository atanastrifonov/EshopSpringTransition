package repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entity.CustomerOrder;
import repository.capi.CustomerOrderRepository;

@Repository
@Transactional
public class CustomerOrderRepositoryImpl implements CustomerOrderRepository {

	@PersistenceContext
	private EntityManager em;

	public static final String NEW_ORDER = "NEW";
	public static final String ACCEPTED_ORDER = "ACCEPTED";
	public static final String DISPATCHED_ORDER = "DISPATCHED";

	@Override
	public void addOrder(CustomerOrder order) {
		em.persist(order);
		em.flush();
	}

	@Override
	public CustomerOrder getOrderById(int orderId) {
		CustomerOrder order = em.find(CustomerOrder.class, orderId);
		em.refresh(order);
		return order;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CustomerOrder> getAllPendingOrders() {
		String theQuery = "SELECT c FROM CustomerOrder c WHERE c.status = :new OR c.status = :accepted OR c.status = :dispatched";

		return em.createQuery(theQuery).setParameter("new", NEW_ORDER).setParameter("accepted", ACCEPTED_ORDER)
				.setParameter("dispatched", DISPATCHED_ORDER).getResultList();

	}

	@Override
	public void updateOrder(CustomerOrder order) {
		em.merge(order);		
	}
}

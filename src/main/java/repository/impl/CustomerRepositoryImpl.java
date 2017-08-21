package repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entity.Customer;
import repository.capi.CustomerRepository;

@Repository
@Transactional
public class CustomerRepositoryImpl implements CustomerRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Customer getCustomerById(Integer id) {
		return em.find(Customer.class, id);
	}

	@Override
	public Customer addCustomer(Customer customer) {
		em.persist(customer);
		return customer;
	}

}

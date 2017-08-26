package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import entity.Customer;
import repository.capi.CustomerRepository;
import service.capi.CustomerService;

@Component
public class DefaultCustomerService implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public void addCustomer(Customer customer) {
		customerRepository.addCustomer(customer);
	}

}

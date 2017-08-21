package repository.capi;

import entity.Customer;

public interface CustomerRepository {
	public Customer getCustomerById(Integer id);
	public Customer addCustomer(Customer customer);
}

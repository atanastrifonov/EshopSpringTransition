package mappers;

import dto.CustomerData;
import entity.Customer;

public class CustomerMapper {

	public static Customer mapSingle(CustomerData customerData) {
		Customer result = new Customer();

		result.setName(customerData.getName());
		result.setEmail(customerData.getEmail());
		result.setPhone(customerData.getPhone());
		result.setAddress(customerData.getAddress());
		result.setCityRegion(customerData.getCityRegion());
		result.setCcNumber(customerData.getCcNumber());

		return result;
	}
}

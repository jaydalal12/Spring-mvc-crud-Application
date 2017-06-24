package com.jayD.spring.service;

import java.util.List;

import com.jayD.spring.entity.Customer;

public interface ICustomerService {
	public List<Customer> getCustomers();

	public void save(Customer thecustomer);

	public Customer getCustomer(int custId);

	public void deleteCust(int custId);
}

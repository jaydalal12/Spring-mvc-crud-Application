package com.jayD.spring.dao;

import java.util.List;

import com.jayD.spring.entity.Customer;

public interface ICustomerDao {
	public List<Customer> getCustomers();

	public void save(Customer thecustomer);

	public Customer getCustomer(int custId);

	public void deleteCust(int custId);
}

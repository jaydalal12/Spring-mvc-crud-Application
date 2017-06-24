package com.jayD.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jayD.spring.dao.ICustomerDao;
import com.jayD.spring.entity.Customer;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	ICustomerDao customerDao;
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customerDao.getCustomers();
	}
	@Override
	@Transactional
	public void save(Customer thecustomer) {
		customerDao.save(thecustomer);
		
	}
	@Override
	@Transactional
	public Customer getCustomer(int custId) {
		// TODO Auto-generated method stub
		return customerDao.getCustomer(custId);
	}
	@Override
	@Transactional
	public void deleteCust(int custId) {
		customerDao.deleteCust(custId);
		
	}

}

package com.jayD.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.jayD.spring.entity.Customer;

@Repository
public class CustomerDaoImpl implements ICustomerDao {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<Customer> getCustomers() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
		List<Customer> customers = theQuery.getResultList();
		// TODO Auto-generated method stub
		return customers;
	}
	@Override
	public void save(Customer thecustomer) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(thecustomer);
		
	}
	@Override
	public Customer getCustomer(int custId) {
		Session currentSession =sessionFactory.getCurrentSession();
		Customer customer = currentSession.get(Customer.class, custId);
		return customer;
	}
	@Override
	public void deleteCust(int custId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query thequery = currentSession.createQuery("delete from Customer where Id=:customerId");
		thequery.setParameter("customerId", custId);
		thequery.executeUpdate();
		
		
	}

}

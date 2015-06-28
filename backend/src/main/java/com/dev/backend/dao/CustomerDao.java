package com.dev.backend.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dev.backend.model.Customer;

@Repository
public class CustomerDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void save(Customer customer) {
	Session session = sessionFactory.getCurrentSession();
	session.saveOrUpdate(customer);
    }

    public void update(Customer customer) {
	Session session = sessionFactory.getCurrentSession();
	session.update(customer);
    }

    public Customer findOne(Long customerId) {
	Session session = sessionFactory.getCurrentSession();
	return (Customer) session.load(Customer.class, customerId);

    }

    @SuppressWarnings("unchecked")
    public List<Customer> findAll() {
	Session session = sessionFactory.getCurrentSession();
	return session.createQuery("from Customer").list();
    }

    public Customer findByCode(String code) {
	Session session = sessionFactory.getCurrentSession();
	return (Customer) session.createQuery("from Customer where code = :code")
		.setParameter("code", code)
		.uniqueResult();
    }

    public void delete(Customer customer) {
	Session session = sessionFactory.getCurrentSession();
	session.delete(customer);
    }

}

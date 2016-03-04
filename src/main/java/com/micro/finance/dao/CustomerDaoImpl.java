package com.micro.finance.dao;

import com.micro.finance.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ssvh on 3/4/16.
 */

@Repository
public class CustomerDaoImpl implements CustomerDao {

    private static final Logger logger = LoggerFactory.getLogger(CustomerDaoImpl.class);
    private SessionFactory sessionFactory;


    public void  setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addCustomer(Customer customer) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.persist(customer);

    }

    @Override
    public void updateCustomer(Customer customer) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.update(customer);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Customer> listCustomer() {
        Session currentSession = sessionFactory.getCurrentSession();
        List<Customer> customers=currentSession.createQuery("from Customer").list();
        return customers;
    }

    @Override
    public Customer getCustomer(int key) {
        Session currentSession = sessionFactory.getCurrentSession();
        Customer customer= (Customer) currentSession.load(Customer.class,key);
        logger.info("Person saved successfully, Person Details="+customer);
        return customer;
    }

    @Override
    public void removeCustomer(int key) {
        Session currentSession = sessionFactory.getCurrentSession();
        Customer customer= (Customer) currentSession.load(Customer.class,key);
        if (customer!=null){
            currentSession.delete(customer);
        }
    }
}

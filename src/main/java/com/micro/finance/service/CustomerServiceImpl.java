package com.micro.finance.service;

import com.micro.finance.dao.CustomerDao;
import com.micro.finance.model.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ssvh on 3/4/16.
 */

@Service
public class CustomerServiceImpl implements CustomerService {


    private CustomerDao customerDao;

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    @Transactional
    public void addCustomer(Customer customer) {
        customerDao.addCustomer(customer);
    }

    @Override
    @Transactional
    public void updateCustomer(Customer customer) {
        customerDao.updateCustomer(customer);
    }

    @Override
    @Transactional
    public List<Customer> listCustomer() {
        return customerDao.listCustomer();
    }

    @Override
    @Transactional
    public Customer getCustomer(int key) {
        return customerDao.getCustomer(key);
    }

    @Override
    @Transactional
    public void removeCustomer(int key) {
        customerDao.removeCustomer(key);
    }
}

package com.micro.finance.service;

import com.micro.finance.model.Customer;

import java.util.List;

/**
 * Created by ssvh on 3/4/16.
 */
public interface CustomerService {

    public void addCustomer(Customer customer);
    public void updateCustomer(Customer customer);
    public List<Customer> listCustomer();
    public Customer getCustomer(int key);
    public void removeCustomer(int key);
}

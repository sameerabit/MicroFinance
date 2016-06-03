package com.micro.finance.dao;

import com.micro.finance.model.Bank;

import java.util.List;

/**
 * Created by ssvh on 3/4/16.
 */
public interface BankDao {

    public void addBank(Bank bank);
    public void updateBank(Bank bank);
    public List<Bank> listBank();
    public Bank getBank(int key);
    public void removeBank(int key);
}

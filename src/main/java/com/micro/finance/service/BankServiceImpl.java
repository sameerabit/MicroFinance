package com.micro.finance.service;

import com.micro.finance.dao.BankDao;
import com.micro.finance.model.Bank;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ssvh on 3/4/16.
 */

@Service
public class BankServiceImpl implements BankService {

    private BankDao bankDao;

    public void setBankDao(BankDao bankDao) {
        this.bankDao = bankDao;
    }

    @Override
    @Transactional
    public void addBank(Bank bank) {
        bankDao.addBank(bank);
    }

    @Override
    @Transactional
    public void updateBank(Bank bank) {
        bankDao.updateBank(bank);
    }

    @Override
    @Transactional
    public List<Bank> listBank() {
        return bankDao.listBank();
    }

    @Override
    @Transactional
    public Bank getBank(int key) {
        return bankDao.getBank(key);
    }

    @Override
    @Transactional
    public void removeBank(int key) {
        bankDao.removeBank(key);
    }
}

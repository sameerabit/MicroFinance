package com.micro.finance.service;

import com.micro.finance.dao.LoanDao;
import com.micro.finance.model.Loan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ssvh on 3/4/16.
 */
@Service
public class LoanServiceImpl implements LoanService {

    private LoanDao loanDao;

    public void setLoanDao(LoanDao loanDao) {
        this.loanDao = loanDao;
    }

    @Override
    @Transactional
    public void addLoan(Loan loan) {
        loanDao.addLoan(loan);
    }

    @Override
    @Transactional
    public void updateLoan(Loan loan) {
        loanDao.updateLoan(loan);
    }

    @Override
    @Transactional
    public List<Loan> listLoan() {
        return loanDao.listLoan();
    }

    @Override
    @Transactional
    public Loan getLoan(int key) {
        return loanDao.getLoan(key);
    }

    @Override
    @Transactional
    public void removeLoan(int key) {
        loanDao.removeLoan(key);
    }
}

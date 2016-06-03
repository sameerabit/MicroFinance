package com.micro.finance.service;

import com.micro.finance.model.Loan;

import java.util.List;

/**
 * Created by ssvh on 3/4/16.
 */
public interface LoanService {

    public void addLoan(Loan loan);
    public void updateLoan(Loan loan);
    public List<Loan> listLoan();
    public Loan getLoan(int key);
    public void removeLoan(int key);
}

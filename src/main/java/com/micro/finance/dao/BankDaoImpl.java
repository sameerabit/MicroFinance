package com.micro.finance.dao;

import com.micro.finance.model.Bank;
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
public class BankDaoImpl implements BankDao {

    private static final Logger logger = LoggerFactory.getLogger(BankDaoImpl.class);
    private SessionFactory sessionFactory;


    public void  setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addBank(Bank bank) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.persist(bank);

    }

    @Override
    public void updateBank(Bank bank) {
        Session currentSession = sessionFactory.getCurrentSession();
        logger.info("Person Details="+bank);
        currentSession.update(bank);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Bank> listBank() {
        Session currentSession = sessionFactory.getCurrentSession();
        List<Bank> banks=currentSession.createQuery("from Bank").list();
        return banks;
    }

    @Override
    public Bank getBank(int key) {
        Session currentSession = sessionFactory.getCurrentSession();
        Bank bank= (Bank) currentSession.load(Bank.class,key);
        logger.info("Person saved successfully, Person Details="+bank);
        return bank;
    }

    @Override
    public void removeBank(int key) {
        Session currentSession = sessionFactory.getCurrentSession();
        Bank bank= (Bank) currentSession.load(Bank.class,key);
        if (bank!=null){
            currentSession.delete(bank);
        }
    }
}

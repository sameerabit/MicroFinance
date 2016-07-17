package com.micro.finance.dao;

import com.micro.finance.model.Loan;
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
public class LoanDaoImpl implements LoanDao {

    private static final Logger logger = LoggerFactory.getLogger(LoanDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addLoan(Loan loan) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(loan);
        logger.info("Loan saved successfully, Loan Details="+loan);
    }

    @Override
    public void updateLoan(Loan loan) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(loan);
        logger.info("Loan updated successfully, Loan Details="+loan);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Loan> listLoan() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Loan> personsList = session.createQuery("from Loan").list();
        for(Loan loan : personsList){
            logger.info("Loan List::"+loan);
        }
        return personsList;
    }

    @Override
    public Loan getLoan(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Loan loan = (Loan) session.load(Loan.class, id);
        logger.info("Loan loaded successfully, Loan details="+loan);
        return loan;
    }

    @Override
    public void removeLoan(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Loan loan = (Loan) session.load(Loan.class, id);
        if(null != loan){
            session.delete(loan);
        }
        logger.info("Loan deleted successfully, person details="+loan);
    }

}

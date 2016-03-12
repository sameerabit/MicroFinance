package com.micro.finance.dao;

import com.micro.finance.model.Branch;
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
public class BranchDaoImpl implements BranchDao {

    private static final Logger logger = LoggerFactory.getLogger(BranchDaoImpl.class);
    private SessionFactory sessionFactory;


    public void  setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addBranch(Branch branch) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.persist(branch);

    }

    @Override
    public void updateBranch(Branch branch) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.update(branch);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Branch> listBranch() {
        Session currentSession = sessionFactory.getCurrentSession();
        List<Branch> branches=currentSession.createQuery("from Branch").list();
        return branches;
    }

    @Override
    public Branch getBranch(int key) {
        Session currentSession = sessionFactory.getCurrentSession();
        Branch branch= (Branch) currentSession.load(Branch.class,key);
        logger.info("Person saved successfully, Person Details="+branch);
        return branch;
    }

    @Override
    public void removeBranch(int key) {
        Session currentSession = sessionFactory.getCurrentSession();
        Branch branch= (Branch) currentSession.load(Branch.class,key);
        if (branch!=null){
            currentSession.delete(branch);
        }
    }
}

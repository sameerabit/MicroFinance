package com.micro.finance.dao;

import com.micro.finance.model.FieldOfficer;
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
public class FieldOfficerDaoImpl implements FieldOfficerDao {

    private static final Logger logger = LoggerFactory.getLogger(FieldOfficerDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addFieldOfficer(FieldOfficer fieldOfficer) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(fieldOfficer);
        logger.info("FieldOfficer saved successfully, FieldOfficer Details="+fieldOfficer);
    }

    @Override
    public void updateFieldOfficer(FieldOfficer fieldOfficer) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(fieldOfficer);
        logger.info("FieldOfficer updated successfully, FieldOfficer Details="+fieldOfficer);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<FieldOfficer> listFieldOfficer() {
        Session session = this.sessionFactory.getCurrentSession();
        List<FieldOfficer> personsList = session.createQuery("from FieldOfficer").list();
        for(FieldOfficer fieldOfficer : personsList){
            logger.info("FieldOfficer List::"+fieldOfficer);
        }
        return personsList;
    }

    @Override
    public FieldOfficer getFieldOfficer(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        FieldOfficer fieldOfficer = (FieldOfficer) session.load(FieldOfficer.class, new Integer(id));
        logger.info("FieldOfficer loaded successfully, FieldOfficer details="+fieldOfficer);
        return fieldOfficer;
    }

    @Override
    public void removeFieldOfficer(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        FieldOfficer fieldOfficer = (FieldOfficer) session.load(FieldOfficer.class, new Integer(id));
        if(null != fieldOfficer){
            session.delete(fieldOfficer);
        }
        logger.info("FieldOfficer deleted successfully, person details="+fieldOfficer);
    }

}

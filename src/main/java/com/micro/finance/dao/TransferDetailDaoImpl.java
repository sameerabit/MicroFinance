package com.micro.finance.dao;

import com.micro.finance.model.TransferDetail;
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
public class TransferDetailDaoImpl implements TransferDetailDao {

    private static final Logger logger = LoggerFactory.getLogger(TransferDetailDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addTransferDetail(TransferDetail transferDetail) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(transferDetail);
        logger.info("TransferDetail saved successfully, TransferDetail Details="+transferDetail);
    }

    @Override
    public void updateTransferDetail(TransferDetail transferDetail) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(transferDetail);
        logger.info("TransferDetail updated successfully, TransferDetail Details="+transferDetail);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<TransferDetail> listTransferDetail() {
        Session session = this.sessionFactory.getCurrentSession();
        List<TransferDetail> transferDetailList = session.createQuery("from TransferDetail").list();
        for(TransferDetail transferDetail : transferDetailList){
            logger.info("TransferDetail List::"+transferDetail);
        }
        return transferDetailList;
    }

    @Override
    public TransferDetail getTransferDetail(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        TransferDetail transferDetail = (TransferDetail) session.load(TransferDetail.class, new Integer(id));
        logger.info("TransferDetail loaded successfully, TransferDetail details="+transferDetail);
        return transferDetail;
    }

    @Override
    public void removeTransferDetail(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        TransferDetail transferDetail = (TransferDetail) session.load(TransferDetail.class, new Integer(id));
        if(null != transferDetail){
            session.delete(transferDetail);
        }
        logger.info("TransferDetail deleted successfully, person details="+transferDetail);
    }

}


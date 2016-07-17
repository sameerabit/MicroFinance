package com.micro.finance.service;

import com.micro.finance.dao.TransferDetailDao;
import com.micro.finance.model.TransferDetail;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ssvh on 3/4/16.
 */

@Service
public class TransferDetailServiceImpl implements TransferDetailService {

    private TransferDetailDao transferDetailDao;

    public void setTransferDetailDao(TransferDetailDao transferDetailDao) {
        this.transferDetailDao = transferDetailDao;
    }

    @Override
    @Transactional
    public void addTransferDetail(TransferDetail transferDetail) {
        transferDetailDao.addTransferDetail(transferDetail);
    }

    @Override
    @Transactional
    public void updateTransferDetail(TransferDetail transferDetail) {
        transferDetailDao.updateTransferDetail(transferDetail);
    }

    @Override
    @Transactional
    public List<TransferDetail> listTransferDetail() {
        return transferDetailDao.listTransferDetail();
    }

    @Override
    @Transactional
    public TransferDetail getTransferDetail(int key) {
        return transferDetailDao.getTransferDetail(key);
    }

    @Override
    @Transactional
    public void removeTransferDetail(int key) {
        transferDetailDao.removeTransferDetail(key);
    }
}

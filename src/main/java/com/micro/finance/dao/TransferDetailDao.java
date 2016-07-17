package com.micro.finance.dao;

import com.micro.finance.model.TransferDetail;

import java.util.List;

/**
 * Created by ssvh on 3/4/16.
 */
public interface TransferDetailDao {

    public void addTransferDetail(TransferDetail transferDetail);
    public void updateTransferDetail(TransferDetail transferDetail);
    public List<TransferDetail> listTransferDetail();
    public TransferDetail getTransferDetail(int key);
    public void removeTransferDetail(int key);
}

package com.micro.finance.service;

import com.micro.finance.dao.FieldOfficerDao;
import com.micro.finance.model.FieldOfficer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ssvh on 3/4/16.
 */
@Service
public class FieldOfficerServiceImpl implements FieldOfficerService {

    private FieldOfficerDao fieldOfficerDao;

    public void setFieldOfficerDao(FieldOfficerDao fieldOfficerDao) {
        this.fieldOfficerDao = fieldOfficerDao;
    }

    @Override
    @Transactional
    public void addFieldOfficer(FieldOfficer fieldOfficer) {
        fieldOfficerDao.addFieldOfficer(fieldOfficer);
    }

    @Override
    @Transactional
    public void updateFieldOfficer(FieldOfficer fieldOfficer) {
        fieldOfficerDao.updateFieldOfficer(fieldOfficer);
    }

    @Override
    @Transactional
    public List<FieldOfficer> listFieldOfficer() {
        return fieldOfficerDao.listFieldOfficer();
    }

    @Override
    @Transactional
    public FieldOfficer getFieldOfficer(int key) {
        return fieldOfficerDao.getFieldOfficer(key);
    }

    @Override
    @Transactional
    public void removeFieldOfficer(int key) {
        fieldOfficerDao.removeFieldOfficer(key);
    }
}

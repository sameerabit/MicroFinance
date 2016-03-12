package com.micro.finance.service;

import com.micro.finance.model.FieldOfficer;

import java.util.List;

/**
 * Created by ssvh on 3/4/16.
 */
public interface FieldOfficerService {

    public void addFieldOfficer(FieldOfficer fieldOfficer);
    public void updateFieldOfficer(FieldOfficer fieldOfficer);
    public List<FieldOfficer> listFieldOfficer();
    public FieldOfficer getFieldOfficer(int key);
    public void removeFieldOfficer(int key);
}

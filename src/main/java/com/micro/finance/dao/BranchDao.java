package com.micro.finance.dao;

import com.micro.finance.model.Branch;

import java.util.List;

/**
 * Created by ssvh on 3/4/16.
 */
public interface BranchDao {

    public void addBranch(Branch branch);
    public void updateBranch(Branch branch);
    public List<Branch> listBranch();
    public Branch getBranch(int key);
    public void removeBranch(int key);
}

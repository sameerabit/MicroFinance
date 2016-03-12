package com.micro.finance.service;

import com.micro.finance.dao.BranchDao;
import com.micro.finance.model.Branch;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ssvh on 3/4/16.
 */

@Service
public class BranchServiceImpl implements BranchService {

    private BranchDao branchDao;

    public void setBranchDao(BranchDao branchDao) {
        this.branchDao = branchDao;
    }

    @Override
    @Transactional
    public void addBranch(Branch branch) {
        branchDao.addBranch(branch);
    }

    @Override
    @Transactional
    public void updateBranch(Branch branch) {
        branchDao.updateBranch(branch);
    }

    @Override
    @Transactional
    public List<Branch> listBranch() {
        return branchDao.listBranch();
    }

    @Override
    @Transactional
    public Branch getBranch(int key) {
        return branchDao.getBranch(key);
    }

    @Override
    @Transactional
    public void removeBranch(int key) {
        branchDao.removeBranch(key);
    }
}

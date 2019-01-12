package com.clx.apps.tt.db.service;

import com.clx.apps.tt.db.model.Branch;

import java.util.List;

public interface BranchService {

  boolean saveBranch(Branch branch);

  Branch findBranch(Integer id);

  List<Branch> findAllBranches();

  boolean delete(Integer id);
}

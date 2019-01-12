package com.clx.apps.tt.db.service.impl;

import com.clx.apps.tt.db.model.Branch;
import com.clx.apps.tt.db.repository.BranchRepository;
import com.clx.apps.tt.db.service.BranchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BranchServiceImpl implements BranchService {

  private static final Logger log = LoggerFactory.getLogger(BranchServiceImpl.class);

  @Autowired private BranchRepository branchRepository;

  @Override
  public boolean saveBranch(Branch branch) {
    try {
      branchRepository.save(branch);
      return true;
    } catch (Exception e) {
      log.error("Error while saving branch: %s", e);
    }
    return false;
  }

  @Override
  public Branch findBranch(Integer id) {
    try {
      Optional<Branch> branchOptional = branchRepository.findById(id);
      if (branchOptional.isPresent()) {
        return branchOptional.get();
      }
    } catch (Exception e) {
      log.error("Error finding branch with id %s: %s", id, e);
    }
    return null;
  }

  @Override
  public List<Branch> findAllBranches() {
    return (List<Branch>) branchRepository.findAll();
  }

  @Override
  public boolean delete(Integer id) {
    try {
      branchRepository.delete(findBranch(id));
      return true;
    } catch (Exception e) {
      log.error("Error while deleting branch with id %s: %s", id, e);
    }
    return false;
  }
}

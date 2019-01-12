package com.clx.apps.tt.db.repository;

import com.clx.apps.tt.db.model.Branch;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends CrudRepository<Branch, Integer> {}

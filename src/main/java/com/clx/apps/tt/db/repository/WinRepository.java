package com.clx.apps.tt.db.repository;

import com.clx.apps.tt.db.model.Win;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WinRepository extends CrudRepository<Win, Integer> {}

package com.clx.apps.tt.db.repository;

import com.clx.apps.tt.db.model.Level;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelRepository extends CrudRepository<Level, Integer> {
}

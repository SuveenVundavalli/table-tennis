package com.clx.apps.tt.db.repository;

import com.clx.apps.tt.db.model.Level;
import com.clx.apps.tt.db.model.Match;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends CrudRepository<Match, Integer> {
}

package com.clx.apps.tt.db.repository;

import com.clx.apps.tt.db.model.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Integer> {}

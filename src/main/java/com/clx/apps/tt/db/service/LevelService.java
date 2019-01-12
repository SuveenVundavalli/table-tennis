package com.clx.apps.tt.db.service;

import com.clx.apps.tt.db.model.Level;

import java.util.List;

public interface LevelService {

  Level saveLevel(Level level);

  Level findLevel(Integer id);

  List<Level> findAllLevels();

  boolean delete(Integer id);
}

package com.clx.apps.tt.db.service.impl;

import com.clx.apps.tt.db.model.Level;
import com.clx.apps.tt.db.repository.LevelRepository;
import com.clx.apps.tt.db.service.LevelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LevelServiceImpl implements LevelService {

  private static final Logger log = LoggerFactory.getLogger(LevelServiceImpl.class);

  @Autowired private LevelRepository levelRepository;

  @Override
  public boolean saveLevel(Level level) {
    try {
      levelRepository.save(level);
      return true;
    } catch (Exception e) {
      log.error("Error while saving level: %s", e);
    }
    return false;
  }

  @Override
  public Level findLevel(Integer id) {
    try {
      Optional<Level> levelOptional = levelRepository.findById(id);
      if (levelOptional.isPresent()) {
        return levelOptional.get();
      }
    } catch (Exception e) {
      log.error("Error finding level with id %s: %s", id, e);
    }
    return null;
  }

  @Override
  public List<Level> findAllLevels() {
    return (List<Level>) levelRepository.findAll();
  }

  @Override
  public boolean delete(Integer id) {
    try {
      levelRepository.delete(findLevel(id));
      return true;
    } catch (Exception e) {
      log.error("Error while deleting level with id %s: %s", id, e);
    }
    return false;
  }
}

package com.clx.apps.tt.db.service.impl;

import com.clx.apps.tt.db.model.Win;
import com.clx.apps.tt.db.repository.WinRepository;
import com.clx.apps.tt.db.service.WinService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WinServiceImpl implements WinService {

  private static final Logger log = LoggerFactory.getLogger(WinServiceImpl.class);

  @Autowired private WinRepository winRepository;

  @Override
  public Win saveWin(Win win) {
    try {
      return winRepository.save(win);
    } catch (Exception e) {
      log.error("Error while saving win: {}", e);
    }
    return null;
  }

  @Override
  public Win findWin(Integer id) {
    try {
      Optional<Win> winOptional = winRepository.findById(id);
      if (winOptional.isPresent()) {
        return winOptional.get();
      }
    } catch (Exception e) {
      log.error("Error finding win with id {}: {}", id, e);
    }
    return null;
  }

  @Override
  public List<Win> findAllWins() {
    return (List<Win>) winRepository.findAll();
  }

  @Override
  public boolean delete(Integer id) {
    try {
      winRepository.delete(findWin(id));
      return true;
    } catch (Exception e) {
      log.error("Error while deleting win with id {}: {}", id, e);
    }
    return false;
  }
}

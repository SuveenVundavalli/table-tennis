package com.clx.apps.tt.db.service.impl;

import com.clx.apps.tt.db.model.Match;
import com.clx.apps.tt.db.repository.MatchRepository;
import com.clx.apps.tt.db.service.MatchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchServiceImpl implements MatchService {

  private static final Logger log = LoggerFactory.getLogger(MatchServiceImpl.class);

  @Autowired private MatchRepository matchRepository;

  @Override
  public Match saveMatch(Match match) {
    try {
      return matchRepository.save(match);
    } catch (Exception e) {
      log.error("Error while saving match: {}", e);
    }
    return null;
  }

  @Override
  public Match findMatch(Integer id) {
    try {
      Optional<Match> matchOptional = matchRepository.findById(id);
      if (matchOptional.isPresent()) {
        return matchOptional.get();
      }
    } catch (Exception e) {
      log.error("Error finding match with id {}: {}", id, e);
    }
    return null;
  }

  @Override
  public List<Match> findAllMatchs() {
    return (List<Match>) matchRepository.findAll();
  }

  @Override
  public boolean delete(Integer id) {
    try {
      matchRepository.delete(findMatch(id));
      return true;
    } catch (Exception e) {
      log.error("Error while deleting match with id {}: {}", id, e);
    }
    return false;
  }
}

package com.clx.apps.tt.db.service;

import com.clx.apps.tt.db.model.Match;

import java.util.List;

public interface MatchService {

    boolean saveMatch(Match match);

    Match findMatch(Integer id);

    List<Match> findAllMatchs();

    boolean delete(Integer id);
    
}

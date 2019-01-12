package com.clx.apps.tt.db.service;

import com.clx.apps.tt.db.model.Win;

import java.util.List;

public interface WinService {

  Win saveWin(Win win);

  Win findWin(Integer id);

  List<Win> findAllWins();

  boolean delete(Integer id);
}

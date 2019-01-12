package com.clx.apps.tt.db.service;

import com.clx.apps.tt.db.model.Player;

import java.util.List;

public interface PlayerService {

  Player savePlayer(Player player);

  Player findPlayer(Integer id);

  List<Player> findAllPlayers();

  boolean delete(Integer id);
}

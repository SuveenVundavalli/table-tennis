package com.clx.apps.tt.db.service.impl;

import com.clx.apps.tt.db.model.Player;
import com.clx.apps.tt.db.repository.PlayerRepository;
import com.clx.apps.tt.db.service.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    private static final Logger log = LoggerFactory.getLogger( PlayerServiceImpl.class );

    @Autowired
    private PlayerRepository playerRepository;


    @Override
    public boolean savePlayer(Player player) {
        try {
            playerRepository.save(player);
            return true;
        } catch (Exception e) {
            log.error("Error while saving player: %s", e);
        }
        return false;
    }

    @Override
    public Player findPlayer(Integer id) {
        try {
            return playerRepository.findById(id).get();
        } catch (Exception e) {
            log.error("Error finding player with id %s: %s", id, e);
        }
        return null;
    }

    @Override
    public List<Player> findAllPlayers() {
        return (List<Player>) playerRepository.findAll();
    }

    @Override
    public boolean delete(Integer id) {
        try {
            playerRepository.delete(findPlayer(id));
            return true;
        } catch (Exception e) {
            log.error("Error while deleting player with id %s: %s", id, e);
        }
        return false;
    }

}

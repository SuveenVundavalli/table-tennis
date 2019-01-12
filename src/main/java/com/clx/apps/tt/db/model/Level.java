package com.clx.apps.tt.db.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "level")
public class Level {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "playerId")
  private Player player;

  private Integer wins;

  private Integer defeats;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Player getPlayer() {
    return player;
  }

  public void setPlayer(Player player) {
    this.player = player;
  }

  public Integer getWins() {
    return wins;
  }

  public void setWins(Integer wins) {
    this.wins = wins;
  }

  public Integer getDefeats() {
    return defeats;
  }

  public void setDefeats(Integer defeats) {
    this.defeats = defeats;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Level level = (Level) o;
    return id.equals(level.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}

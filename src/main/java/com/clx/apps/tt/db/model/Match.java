package com.clx.apps.tt.db.model;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "match")
public class Match {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "playerOneId")
  private Player playerOne;

  @ManyToOne
  @JoinColumn(name = "playerTwoId")
  private Player playerTwo;

  @ManyToOne
  @JoinColumn(name = "winnerId")
  private Player winner;

  @ManyToOne
  @JoinColumn(name = "loserId")
  private Player loser;

  private Integer winnerScore;

  private Integer loserScore;

  @Generated(GenerationTime.INSERT)
  @Column(
      nullable = false,
      insertable = false,
      updatable = false,
      columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP()")
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdAt;

  @Generated(GenerationTime.ALWAYS)
  @Column(
      insertable = false,
      updatable = false,
      columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP()")
  @Temporal(TemporalType.TIMESTAMP)
  private Date updatedAt;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Player getPlayerOne() {
    return playerOne;
  }

  public void setPlayerOne(Player playerOne) {
    this.playerOne = playerOne;
  }

  public Player getPlayerTwo() {
    return playerTwo;
  }

  public void setPlayerTwo(Player playerTwo) {
    this.playerTwo = playerTwo;
  }

  public Player getWinner() {
    return winner;
  }

  public void setWinner(Player winner) {
    this.winner = winner;
  }

  public Player getLoser() {
    return loser;
  }

  public void setLoser(Player loser) {
    this.loser = loser;
  }

  public Integer getWinnerScore() {
    return winnerScore;
  }

  public void setWinnerScore(Integer winnerScore) {
    this.winnerScore = winnerScore;
  }

  public Integer getLoserScore() {
    return loserScore;
  }

  public void setLoserScore(Integer loserScore) {
    this.loserScore = loserScore;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Match match = (Match) o;
    return id.equals(match.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}

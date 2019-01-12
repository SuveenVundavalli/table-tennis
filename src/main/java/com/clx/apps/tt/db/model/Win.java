package com.clx.apps.tt.db.model;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "playerWin")
public class Win {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "matchId")
  private Match match;

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

  public Match getMatch() {
    return match;
  }

  public void setMatch(Match match) {
    this.match = match;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Win match = (Win) o;
    return id.equals(match.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}

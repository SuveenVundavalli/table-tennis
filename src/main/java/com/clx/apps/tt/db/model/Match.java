package com.clx.apps.tt.db.model;

import com.clx.apps.tt.util.converter.MatchStatusConverter;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "playerMatch")
public class Match {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @OneToOne(fetch = FetchType.LAZY, mappedBy = "match", cascade = CascadeType.ALL)
  private Win win;

  @ManyToOne
  @JoinColumn(name = "playerOneId")
  private Player playerOne;

  @ManyToOne
  @JoinColumn(name = "playerTwoId")
  private Player playerTwo;

  private Integer playerOneScore;

  private Integer playerTwoScore;

  @Column(columnDefinition = "enum")
  @Convert(converter = MatchStatusConverter.class)
  private Status status;

  @Generated(GenerationTime.INSERT)
  @Column(
      nullable = false,
      insertable = false,
      updatable = false,
      columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP()")
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdAt;

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

  public Integer getPlayerOneScore() {
    return playerOneScore;
  }

  public void setPlayerOneScore(Integer playerOneScore) {
    this.playerOneScore = playerOneScore;
  }

  public Integer getPlayerTwoScore() {
    return playerTwoScore;
  }

  public void setPlayerTwoScore(Integer playerTwoScore) {
    this.playerTwoScore = playerTwoScore;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Win getWin() {
    return win;
  }

  public void setWin(Win win) {
    this.win = win;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
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

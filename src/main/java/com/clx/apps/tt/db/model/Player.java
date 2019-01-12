package com.clx.apps.tt.db.model;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "player")
public class Player {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String firstName;

  private String lastName;

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

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "playerOne")
  private Set<Match> playerOnes;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "playerTwo")
  private Set<Match> playerTwos;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "winner")
  private Set<Win> winners;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "loser")
  private Set<Win> losers;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "player")
  private Set<Level> levels;

  @ManyToOne
  @JoinColumn(name = "branchId")
  private Branch branch;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
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

  public Set<Match> getPlayerOnes() {
    return playerOnes;
  }

  public void setPlayerOnes(Set<Match> playerOnes) {
    this.playerOnes = playerOnes;
  }

  public Set<Match> getPlayerTwos() {
    return playerTwos;
  }

  public void setPlayerTwos(Set<Match> playerTwos) {
    this.playerTwos = playerTwos;
  }

  public Set<Win> getWinners() {
    return winners;
  }

  public void setWinners(Set<Win> winners) {
    this.winners = winners;
  }

  public Set<Win> getLosers() {
    return losers;
  }

  public void setLosers(Set<Win> losers) {
    this.losers = losers;
  }

  public Set<Level> getLevels() {
    return levels;
  }

  public void setLevels(Set<Level> levels) {
    this.levels = levels;
  }

  public Branch getBranch() {
    return branch;
  }

  public void setBranch(Branch branch) {
    this.branch = branch;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Player player = (Player) o;
    return id.equals(player.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}

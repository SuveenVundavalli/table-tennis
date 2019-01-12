package com.clx.apps.tt.db.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "branch")
public class Branch {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "branch")
  private Set<Player> players;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Set<Player> getPlayers() {
    return players;
  }

  public void setPlayers(Set<Player> players) {
    this.players = players;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Branch branch = (Branch) o;
    return id.equals(branch.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}

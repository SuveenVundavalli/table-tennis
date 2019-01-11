package com.clx.apps.tt.db.model;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;

    private String lastName;

    private String office;

    @Generated(GenerationTime.INSERT)
    @Column(
            nullable = false,
            insertable = false,
            updatable = false,
            columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP()"
    )
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Generated(GenerationTime.ALWAYS)
    @Column(
            insertable = false,
            updatable = false,
            columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP()"
    )
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "playerOne")
    private Set<Match> playerOnes;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "playerTwo")
    private Set<Match> playerTwos;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "winner")
    private Set<Match> winners;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "loser")
    private Set<Match> losers;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "player")
    private Set<Level> Levels;

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

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
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

    public Set<Match> getWinners() {
        return winners;
    }

    public void setWinners(Set<Match> winners) {
        this.winners = winners;
    }

    public Set<Match> getLosers() {
        return losers;
    }

    public void setLosers(Set<Match> losers) {
        this.losers = losers;
    }

    public Set<Level> getLevels() {
        return Levels;
    }

    public void setLevels(Set<Level> levels) {
        Levels = levels;
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

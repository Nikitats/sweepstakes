package com.totalizator.dao.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by home
 */
@Entity
@Table(name = "clubs")
public class Club extends GenericEntity {

    @Column(name = "Name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Nation")
    private Nation nation;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Sport")
    private Sport sport;

    @Column(name = "Popularity", nullable = false)
    private long popularity;

    @OneToMany(mappedBy = "club", cascade = CascadeType.ALL)
    private Set<TournamentTeams> tournamentTeams;

    public long getPopularity() {
        return popularity;
    }

    @OneToMany(mappedBy = "homeClub", cascade = CascadeType.ALL)
    private Set<Match> homeMatches;

    public Set<Match> getGuestMatches() {
        return guestMatches;
    }

    public void setGuestMatches(Set<Match> guestMatches) {
        this.guestMatches = guestMatches;
    }

    public Set<Match> getHomeMatches() {
        return homeMatches;
    }

    public void setHomeMatches(Set<Match> homeMatches) {
        this.homeMatches = homeMatches;
    }

    @OneToMany(mappedBy = "guestClub", cascade = CascadeType.ALL)
    private Set<Match> guestMatches;

    public void setPopularity(long popularity) {
        this.popularity = popularity;
    }

    public Set<TournamentTeams> getTournamentTeams() {
        return tournamentTeams;
    }

    public void setTournamentTeams(Set<TournamentTeams> tournamentTeams) {
        this.tournamentTeams = tournamentTeams;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Nation getNation() {
        return nation;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
    }
}

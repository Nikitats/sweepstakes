package com.totalizator.dao.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by home
 */
@Entity
@Table(name = "tournament")
public class Tournament extends GenericEntity {

    @Column(name = "name", nullable =  false)
    private String name;

    @Column(name = "popularity", nullable = false)
    private long popularity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sport")
    private Sport sport;

    @OneToMany(mappedBy = "tournament", cascade = CascadeType.ALL)
    private Set<TournamentTeams> tournamentTeams;

    @OneToMany(mappedBy = "tournament", cascade = CascadeType.ALL)
    private Set<Match> matches;

    public Set<Match> getMatches() {
        return matches;
    }

    public void setMatches(Set<Match> matches) {
        this.matches = matches;
    }

    public Set<TournamentTeams> getTournamentTeams() {
        return tournamentTeams;
    }

    public void setTournamentTeams(Set<TournamentTeams> tournamentTeams) {
        this.tournamentTeams = tournamentTeams;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPopularity() {
        return popularity;
    }

    public void setPopularity(long popularity) {
        this.popularity = popularity;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }
}

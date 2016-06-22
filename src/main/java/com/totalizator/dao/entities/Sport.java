package com.totalizator.dao.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by home
 */
@Entity
@Table(name = "sport")
public class Sport extends GenericEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "popularity", nullable = false)
    private long popularity;

    @OneToMany(mappedBy = "sport", cascade = CascadeType.ALL)
    private Set<Club> clubs;


    public Set<Club> getClubs() {
        return clubs;
    }

    public void setClubs(Set<Club> clubs) {
        this.clubs = clubs;
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
}

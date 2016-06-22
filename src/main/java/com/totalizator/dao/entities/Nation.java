package com.totalizator.dao.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by home
 */
@Entity
@Table(name = "nations")
public class Nation extends GenericEntity {

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "continent", nullable = true)
    private String continent;

    @OneToMany(mappedBy = "nation", cascade = CascadeType.ALL)
    private Set<Club> clubs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public Set<Club> getClubs() {
        return clubs;
    }

    public void setClubs(Set<Club> clubs) {
        this.clubs = clubs;
    }
}

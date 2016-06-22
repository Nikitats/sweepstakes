package com.totalizator.dao.entities;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Andrei Savchuk.
 */
@Entity
@Table(name = "bet")
public class Bet extends GenericEntity {

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "amount", nullable = false)
    private float amount;

    @Column(name = "win", nullable = false)
    private boolean win;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "match")
    private Match match;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user")
    private User user;

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }
}

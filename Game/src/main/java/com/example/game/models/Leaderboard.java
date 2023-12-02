package com.example.game.models;

import jakarta.persistence.*;

@Entity
public class Leaderboard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_id", insertable=false, updatable=false)
    private Long user_id;
    private Long score;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private UserData user;

    public Leaderboard(Long id, Long user_id, Long score, UserData user) {
        this.id = id;
        this.user_id = user_id;
        this.score = score;
        this.user = user;
    }

    public Leaderboard() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return user_id;
    }

    public void setUserId(Long user_id) {
        this.user_id = user_id;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public UserData getUser() {
        return user;
    }

    public void setUser(UserData user) {
        this.user = user;
    }
}

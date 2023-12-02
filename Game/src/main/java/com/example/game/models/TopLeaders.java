package com.example.game.models;

public class TopLeaders {
    private Long position;
    private String login;
    private Long score;

    public TopLeaders(Long position, String login, Long score) {
        this.position = position;
        this.login = login;
        this.score = score;
    }

    public TopLeaders() {
    }

    public Long getPosition() {
        return position;
    }

    public void setPosition(Long position) {
        this.position = position;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }
}

package com.example.game.service;

import com.example.game.repositories.LeaderboardRepo;
import com.example.game.repositories.UserDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    private final LeaderboardRepo leaderboardRepo;

    @Autowired
    public GameService(LeaderboardRepo leaderboardRepo) {
        this.leaderboardRepo = leaderboardRepo;
    }

    public void AddScore(String login, int score) {
        leaderboardRepo.AddScore(login, score);
    }
}

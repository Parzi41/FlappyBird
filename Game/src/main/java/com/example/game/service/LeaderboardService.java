package com.example.game.service;

import com.example.game.models.TopLeaders;
import com.example.game.repositories.LeaderboardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class LeaderboardService {
    private final LeaderboardRepo leaderboardRepo;

    @Autowired
    public LeaderboardService(LeaderboardRepo leaderboardRepo) {
        this.leaderboardRepo = leaderboardRepo;
    }

    public List<TopLeaders> GetTopUser() {
        return leaderboardRepo.GetTopUser();
    }
}

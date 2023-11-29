package com.example.game.repositories;

import com.example.game.models.Leaderboard;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LeaderboardRepo extends CrudRepository<Leaderboard, Long> {
}

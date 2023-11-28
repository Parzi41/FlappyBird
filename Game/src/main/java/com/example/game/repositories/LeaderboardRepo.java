package com.example.game.repositories;

import com.example.game.models.Leaderboard;
import org.springframework.data.repository.CrudRepository;

public interface LeaderboardRepo extends CrudRepository<Leaderboard, Long> {
}

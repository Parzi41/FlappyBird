package com.example.game.repositories;

import com.example.game.models.Leaderboard;
import com.example.game.models.TopLeaders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface LeaderboardRepo extends JpaRepository<Leaderboard, Void> {
    @Query(value = "EXEC AddScore :login, :score", nativeQuery = true)
    int AddScore(@Param("login") String login, @Param("score") int score);

    @Query("SELECT NEW com.example.game.models.TopLeaders(" +
            "ROW_NUMBER() OVER(ORDER BY lb.score DESC), ud.login, lb.score) " +
            "FROM Leaderboard lb " +
            "JOIN UserData ud ON ud.user_id = lb.user_id " +
            "ORDER BY lb.score DESC")
    List<TopLeaders> GetTopUser();
}

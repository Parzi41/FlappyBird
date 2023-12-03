package com.example.game;

import com.example.game.models.Leaderboard;
import com.example.game.models.UserData;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LeaderboardTest {

    @Test
    void testLeaderboardConstructorAndAccessors() {
        // Test data
        Long id = 1L;
        Long userId = 100L;
        Long score = 500L;
        UserData user = new UserData();

        // Create a Leaderboard instance using the constructor
        Leaderboard leaderboard = new Leaderboard(id, userId, score, user);

        // Verify values set by the constructor
        assertThat(leaderboard.getId()).isEqualTo(id);
        assertThat(leaderboard.getUserId()).isEqualTo(userId);
        assertThat(leaderboard.getScore()).isEqualTo(score);
        assertThat(leaderboard.getUser()).isEqualTo(user);

        // Test accessors (getters and setters)
        Long newId = 2L;
        Long newUserId = 200L;
        Long newScore = 1000L;
        UserData newUser = new UserData();

        // Update values using setters
        leaderboard.setId(newId);
        leaderboard.setUserId(newUserId);
        leaderboard.setScore(newScore);
        leaderboard.setUser(newUser);

        // Verify updated values using getters
        assertThat(leaderboard.getId()).isEqualTo(newId);
        assertThat(leaderboard.getUserId()).isEqualTo(newUserId);
        assertThat(leaderboard.getScore()).isEqualTo(newScore);
        assertThat(leaderboard.getUser()).isEqualTo(newUser);
    }

    @Test
    void testLeaderboardDefaultConstructor() {
        // Test default constructor
        Leaderboard leaderboard = new Leaderboard();

        // Verify default values (null or 0 for numeric types)
        assertThat(leaderboard.getId()).isNull();
        assertThat(leaderboard.getUserId()).isNull();
        assertThat(leaderboard.getScore()).isNull();
        assertThat(leaderboard.getUser()).isNull();
    }
}



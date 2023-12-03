package com.example.game;

import com.example.game.repositories.LeaderboardRepo;
import com.example.game.service.GameService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

class GameServiceTest {

    @Mock
    private LeaderboardRepo leaderboardRepo;

    @InjectMocks
    private GameService gameService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testAddScore() {
        String testLogin = "testLogin";
        int testScore = 100;

        gameService.AddScore(testLogin, testScore);

        verify(leaderboardRepo).AddScore(eq(testLogin), eq(testScore));
    }
}


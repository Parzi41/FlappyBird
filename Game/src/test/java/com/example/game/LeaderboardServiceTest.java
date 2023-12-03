package com.example.game;

import com.example.game.models.TopLeaders;
import com.example.game.repositories.LeaderboardRepo;
import com.example.game.service.LeaderboardService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class LeaderboardServiceTest {
    @Mock
    private LeaderboardRepo leaderboardRepo;

    @InjectMocks
    private LeaderboardService leaderboardService;

    @Test
    void testGetTopUser() {
        List<TopLeaders> expectedTopLeaders = Collections.singletonList(new TopLeaders(1L, "testuser", 100L));
        Mockito.when(leaderboardRepo.GetTopUser()).thenReturn(expectedTopLeaders);

        List<TopLeaders> actualTopLeaders = leaderboardService.GetTopUser();

        assertThat(actualTopLeaders).isEqualTo(expectedTopLeaders);

        Mockito.verify(leaderboardRepo).GetTopUser();
    }
}


package com.example.game;

import com.example.game.models.TopLeaders;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
class TopLeadersTest {

    @Test
    void testTopLeadersConstructorAndAccessors() {
        // Test data
        Long position = 1L;
        String login = "testuser";
        Long score = 500L;

        // Create a TopLeaders instance using the constructor
        TopLeaders topLeaders = new TopLeaders(position, login, score);

        // Verify values set by the constructor
        assertThat(topLeaders.getPosition()).isEqualTo(position);
        assertThat(topLeaders.getLogin()).isEqualTo(login);
        assertThat(topLeaders.getScore()).isEqualTo(score);

        // Test accessors (getters and setters)
        Long newPosition = 2L;
        String newLogin = "newuser";
        Long newScore = 1000L;

        // Update values using setters
        topLeaders.setPosition(newPosition);
        topLeaders.setLogin(newLogin);
        topLeaders.setScore(newScore);

        // Verify updated values using getters
        assertThat(topLeaders.getPosition()).isEqualTo(newPosition);
        assertThat(topLeaders.getLogin()).isEqualTo(newLogin);
        assertThat(topLeaders.getScore()).isEqualTo(newScore);
    }

    @Test
    void testTopLeadersDefaultConstructor() {
        // Test default constructor
        TopLeaders topLeaders = new TopLeaders();

        // Verify default values (null or 0 for numeric types)
        assertThat(topLeaders.getPosition()).isNull();
        assertThat(topLeaders.getLogin()).isNull();
        assertThat(topLeaders.getScore()).isNull();
    }
}

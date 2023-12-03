package com.example.game;

import com.example.game.models.UserData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
class UserDataTest {

    @Test
    void testUserDataConstructorAndAccessors() {
        // Test data
        String login = "testuser";
        String pass = "testpass";

        UserData userData = new UserData(login, pass);

        // Verify values set by the constructor
        assertThat(userData.getLogin()).isEqualTo(login);
        assertThat(userData.getPass()).isEqualTo(pass);

        Long newUserId = 1L;
        String newLogin = "newuser";
        String newPass = "newpass";

        userData.setId(newUserId);
        userData.setLogin(newLogin);
        userData.setPass(newPass);

        // Verify updated values using getters
        assertThat(userData.getId()).isEqualTo(newUserId);
        assertThat(userData.getLogin()).isEqualTo(newLogin);
        assertThat(userData.getPass()).isEqualTo(newPass);
    }

    @Test
    void testUserDataDefaultConstructor() {
        UserData userData = new UserData();

        assertThat(userData.getId()).isNull();
        assertThat(userData.getLogin()).isNull();
        assertThat(userData.getPass()).isNull();
    }
}


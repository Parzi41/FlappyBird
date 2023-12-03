package com.example.game;

import com.example.game.repositories.UserDataRepo;
import com.example.game.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserServiceTest {

    @Mock
    private UserDataRepo userDataRepo;

    @InjectMocks
    private UserService userService;

    @Test
    void testSignIn() {
        // Test data
        String login = "testuser";
        String password = "testpass";
        int expectedResult = 0; // Adjust this based on your expected result

        // Mock the behavior of userDataRepo.signIn method
        Mockito.when(userDataRepo.signIn(login, password, -1)).thenReturn(expectedResult);

        // Call the method to be tested
        int actualResult = userService.signIn(login, password);

        // Verify the result
        assertThat(actualResult).isEqualTo(expectedResult);

        // Verify that userDataRepo.signIn method was called with the correct arguments
        Mockito.verify(userDataRepo).signIn(login, password, -1);
    }
}


package com.example.game;

import com.example.game.controllers.GameController;
import com.example.game.service.GameService;
import com.example.game.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class GameControllerTest {
    @Mock
    private UserService userService;

    @Mock
    private GameService gameService;

    @Mock
    private HttpSession session;

    @Mock
    private Model model;

    @InjectMocks
    private GameController gameController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSignInSuccess() {
        when(userService.signIn(anyString(), anyString())).thenReturn(0);
        when(session.getAttribute("login")).thenReturn("testUser");

        String result = gameController.signIn("testLogin", "testPassword", session, model);

        verify(session).setAttribute("login", "testLogin");
        verify(gameService, never()).AddScore(anyString(), anyInt());
        assert(result.equals("game"));
    }

    @Test
    void testSignInFailure() {
        when(userService.signIn(anyString(), anyString())).thenReturn(1);

        String result = gameController.signIn("testLogin", "testPassword", session, model);

        verify(session, never()).setAttribute(anyString(), anyString());
        verify(gameService, never()).AddScore(anyString(), anyInt());
        assert(result.equals("sign_up"));
    }
}
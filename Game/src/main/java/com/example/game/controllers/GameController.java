package com.example.game.controllers;
import com.example.game.models.Leaderboard;
import com.example.game.models.UserData;
import com.example.game.repositories.UserDataRepo;
import com.example.game.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class GameController {
    private final UserService userService;

    @Autowired
    public GameController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/game/sign_up")
    public String signIn(Model model) {
        model.addAttribute("signup", "signup page");
        return "sign_up";
    }

    @PostMapping("/game/sign_up")
    public String signIn(@RequestParam String login, @RequestParam String password, Model model) {
        int result = userService.signIn(login, password);

        if(result == 0) {
            return "game";
        }
        else {
            return "sign_up";
        }
    }

    /*@GetMapping("/game")
    public String game(Model model) {
        Iterable<UserData> users = userRepo.findAll();


        model.addAttribute("game", users);
        return "game";
    }*/
}

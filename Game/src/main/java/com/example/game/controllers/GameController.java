package com.example.game.controllers;
import com.example.game.models.Leaderboard;
import com.example.game.models.UserData;
import com.example.game.repositories.UserDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class GameController {
    @Autowired
    private UserDataRepo userRepo;
    @GetMapping("/game")
    public String leaderboard(Model model) {
        Iterable<UserData> users = userRepo.findAll();

        boolean containsElement = false;
        for (UserData currentElement : users) {
            if (currentElement.equals(users)) {
                containsElement = true;
                break;
            }
        }

        model.addAttribute("leaders", users);
        return "leaderboard";
    }
}

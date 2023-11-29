package com.example.game.controllers;

import com.example.game.models.Leaderboard;
import com.example.game.repositories.LeaderboardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LeaderboardController {
    @Autowired
    private LeaderboardRepo leaderRepo;

    @GetMapping("/leaderboard")
    public String leaderboard(Model model) {
        Iterable<Leaderboard> leaders = leaderRepo.findAll();
        model.addAttribute("leaders", leaders);
        return "leaderboard";
    }
}

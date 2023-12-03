package com.example.game.controllers;

import com.example.game.models.TopLeaders;
import com.example.game.repositories.LeaderboardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;


@Controller
public class LeaderboardController {
    @Autowired
    private LeaderboardRepo leaderRepo;

    @GetMapping("/leaderboard")
    public String leaderboard(Model model) {
        List<TopLeaders> leaders = leaderRepo.GetTopUser();

        model.addAttribute("leaders", leaders);
        return "leaderboard";
    }
}

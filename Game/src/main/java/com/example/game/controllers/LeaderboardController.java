package com.example.game.controllers;

import com.example.game.models.Leaderboard;
import com.example.game.repositories.LeaderboardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Controller
public class LeaderboardController {
    @Autowired
    private LeaderboardRepo leaderRepo;

    @GetMapping("/leaderboard")
    public String leaderboard(Model model) {
        Iterable<Leaderboard> leaders = leaderRepo.findAll();

        List<Leaderboard> topElements = getTopElements(leaders, 10);

        model.addAttribute("leaders", topElements);
        return "leaderboard";
    }

    private static List<Leaderboard> getTopElements(Iterable<Leaderboard> iterable, int count) {
        List<Leaderboard> list = StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());

        list.sort(Comparator.comparing(Leaderboard::getScore).reversed());

        return list.subList(0, Math.min(count, list.size()));
    }
}

package com.example.soul.controller;

import com.example.soul.entity.MatchResult;
import com.example.soul.service.MatchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/match")
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping("/{userId}")
    public List<MatchResult> matchUsers(@PathVariable Long userId) {
        return matchService.findMatches(userId);
    }
}
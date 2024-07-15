package com.knf.dev.demo.controller;

import com.knf.dev.demo.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/game")
public class GameController {
    private static ArrayList<Long> playersId = new ArrayList<>();
    private final UserService userService;

    public GameController(UserService userService) {
        this.userService = userService;
    }
    public static boolean addPlayer(Long playerId) {
        if(playersId.contains(playerId)) {
            return false;
        }
        else {
            playersId.add(playerId);
            return true;
        }
    }
    @GetMapping("/find")
    public String find() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        GameController.addPlayer(userService.findUserByEmail(auth.getName()).getId());
//        playersId.add(userService.findUserByEmail(auth.getName()).getId());
        if(playersId.size() % 2 == 0) {

            return "redirect:/game/play-"+playersId.get(playersId.size()-1) + "-" + playersId.get(playersId.size()-2);//game/play-id1-id2
        }
        System.out.println(playersId);
        return "game/find";
    }

    @GetMapping("/play-{id1}-{id2}")
    public String playId1Id2(@PathVariable Long id1, @PathVariable Long id2) {
        return "game/playUsers";
    }
}

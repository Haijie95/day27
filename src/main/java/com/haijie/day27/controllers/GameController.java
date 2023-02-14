package com.haijie.day27.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.haijie.day27.models.Game;
import com.haijie.day27.services.GameService;


@Controller
@RequestMapping("")
public class GameController {

    @Autowired
    GameService gameSvc;

    @GetMapping("/")
    public String listAllGames(Model model,@RequestParam(defaultValue ="30") int limit
    ,@RequestParam(defaultValue ="0") int offset){
        
        List<Game> gList = gameSvc.getAllGames(limit,offset);
        model.addAttribute("gList",gList);
        model.addAttribute("next",offset+limit);
        return "index";
    }

    @GetMapping("/game/{gid}")
    public String getGameDetails(@PathVariable int gid,Model model){

        Game game = gameSvc.getGameDetails(gid);

        model.addAttribute("id",gid);
        model.addAttribute("game",game);

        return"details";
    }
    
}

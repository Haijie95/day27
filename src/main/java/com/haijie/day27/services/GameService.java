package com.haijie.day27.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haijie.day27.models.Game;
import com.haijie.day27.repositories.GameRepository;

@Service
public class GameService {
    
    @Autowired
    GameRepository gameRepo;

    public List<Game> getAllGames(int limit, int offset){
        return gameRepo.getAllGames(limit, offset);
    }
    public List<Game> getAllGames(){
        return gameRepo.getAllGames();
    }
    public Game getGameDetails(int gid){
        return gameRepo.getGameDetails(gid);
    }
}

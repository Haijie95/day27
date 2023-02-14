package com.haijie.day27.repositories;

import java.util.LinkedList;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.haijie.day27.models.Comment;
import com.haijie.day27.models.Game;
import static com.haijie.day27.repositories.Queries.*;

@Repository
public class GameRepository {
    
    @Autowired 
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private MongoTemplate template;

    public List<Game> getAllGames(){
        return getAllGames(30, 0);
    }
    //gid,name
    public List<Game> getAllGames(int limit, int offset){
        SqlRowSet rs = jdbcTemplate.queryForRowSet(selectSQL,limit,offset);
        List<Game> games = new LinkedList<>();

        while(rs.next())
            games.add(Game.createSummary(rs));

        return games;
    }

    public Game getGameDetails(int gid){
        
        SqlRowSet rs = jdbcTemplate.queryForRowSet(selectByIdSQL,gid);
        List<Game> games = new LinkedList<>();

        while(rs.next()){
        games.add(Game.createDetails(rs));
        }
        return games.get(0);
    }
    public void insertComment(Comment comment) {
        Document doc = comment.toDocument();
		template.insert(doc, COLLECTION_COMMENTS);
    }



}

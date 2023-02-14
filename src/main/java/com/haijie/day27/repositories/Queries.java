package com.haijie.day27.repositories;

public class Queries {
    static final String selectSQL="select gid, name  from game limit ? offset ?";
    static final String selectByIdSQL="select name,year,ranking,users_rated,url,image from game where gid=?";
    static final String COLLECTION_COMMENTS="comments";
}

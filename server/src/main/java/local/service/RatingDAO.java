package local.service;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class RatingDAO {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    
    public RatingDAO(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public void insertRating(String userName, UUID infoId, int rating) {
        String sql = "INSERT INTO rating (user_name, info_id, rating) VALUES (:userName, :infoId, :rating)";
        
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("userName", userName);
        params.addValue("infoId", infoId);
        params.addValue("rating", rating);
        
        jdbcTemplate.update(sql, params);
    }
    
    public void updateRating(String userName, UUID infoId, int newRating) {
        String sql = "UPDATE rating SET rating = :newRating WHERE user_name = :userName AND info_id = :infoId";
        
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("userName", userName);﻿</code>
    <code><pre>    params.addValue("infoId", infoId);
    params.addValue("newRating", newRating);
        
    jdbcTemplate.update(sql, params);
}
package local.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import java.util.*;

public class InformationService {
    private final JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert simpleJdbcInsert;
    
    public InformationService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        // Configure SimpleJdbcInsert
        this.simpleJdbcInsert = new SimpleJdbcInsert(this.jdbcTemplate).withTableName("information").usingGeneratedKeyColumns("id");
    }
    
    public UUID insertInformation(String description, String jsonData) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("description", description);
        parameters.put("json_data", jsonData);
        
        Number key = simpleJdbcInsert.executeAndReturnKey(parameters);
        
        return UUID.fromString(key.toString());
    }
    
    public void updateInformation(UUID id, String description, String jsonData) {
        jdbcTemplate.update("UPDATE information SET description = ?, json_data = ? WHERE id = ?", 
                            description, jsonData, id.toString());
    }

    public void deleteInformation(UUID id) {
        jdbcTemplate.update("DELETE FROM information WHERE id = ?", id.toString());
    }
}

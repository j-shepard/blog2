package local.service;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {
  @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

        public void addUser(String userName, String fullName) {
            String sql = "INSERT INTO users (user_name, full_name) VALUES (:username, :fullName)";

            MapSqlParameterSource parameters = new MapSqlParameterSource();
            parameters.addValue("username", userName);
            parameters.addValue("fullName", fullName);

            namedParameterJdbcTemplate.update(sql, parameters);
        }

        public void updateUser(String oldUserName, String newUserName, String newFullName) {
            String sql = "UPDATE users SET user_name=:newUsername, full_name=:newFullName WHERE user_name=:oldUsername";

            MapSqlParameterSource parameters = new MapSqlParameterSource();
            parameters.addValue("newUsername", newUserName);
            parameters.addValue("newFullName", newFullName);
            parameters.addValue("oldUsername", oldUserName);

            namedParameterJdbcTemplate.update(sql, parameters);
        }
    }
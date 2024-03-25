package com.webapp;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;
import java.util.Map;

public class UserDAO {
    public static List<User> queryDataSource( /*DataSourceProperties.*/DataSourceConfig dataSourceConfig) {
        JdbcTemplate jdbcTemplate = JdbcTemplateFactory.getJdbcTemplate(dataSourceConfig);

        String sql = "SELECT * FROM " + dataSourceConfig.getTable();

        RowMapper<User> rowMapper = (rs, rowNum) -> {
            Map<String, String> mapping = dataSourceConfig.getMapping();
            String id = rs.getString(mapping.get("id"));
            String username = rs.getString(mapping.get("username"));
            String name = rs.getString(mapping.get("name"));
            String surname = rs.getString(mapping.get("surname"));
            return new User(id, username, name, surname);
        };

        return jdbcTemplate.query(sql, rowMapper);
    }
}

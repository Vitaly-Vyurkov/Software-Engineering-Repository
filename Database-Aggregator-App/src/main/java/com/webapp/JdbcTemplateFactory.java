package com.webapp;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.HashMap;
import java.util.Map;

public class JdbcTemplateFactory {
    private static Map<String, JdbcTemplate> jdbcTemplateMap = new HashMap<>();

    public static JdbcTemplate getJdbcTemplate(DataSourceConfig dataSourceConfig) {
        String dataSourceName = dataSourceConfig.getName();

        if (jdbcTemplateMap.containsKey(dataSourceName)) {
            return jdbcTemplateMap.get(dataSourceName);
        } else {
            JdbcTemplate jdbcTemplate = createJdbcTemplate(dataSourceConfig);
            jdbcTemplateMap.put(dataSourceName, jdbcTemplate);
            return jdbcTemplate;
        }
    }
    private static JdbcTemplate createJdbcTemplate(DataSourceConfig dataSourceConfig) {
        org.springframework.jdbc.datasource.DriverManagerDataSource dataSource = new org.springframework.jdbc.datasource.DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(dataSourceConfig.getUrl());
        dataSource.setUsername(dataSourceConfig.getUser());
        dataSource.setPassword(dataSourceConfig.getPassword());
        return new JdbcTemplate(dataSource);
    }
}


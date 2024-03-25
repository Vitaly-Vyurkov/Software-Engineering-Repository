package com.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

@Configuration
public class SpringConfigs {

    @Autowired
    DataSourceProperties dataSourceProperties;

}

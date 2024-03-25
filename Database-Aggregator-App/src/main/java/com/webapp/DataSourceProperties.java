package com.webapp;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ConfigurationProperties
public class DataSourceProperties {

    private List<DataSourceConfig> dataSources = new ArrayList<> ();

    public List<DataSourceConfig> getDataSources () {
        return dataSources;
    }

    public void setDataSources ( List<DataSourceConfig> dataSources ) {
        this.dataSources = dataSources;
    }
}

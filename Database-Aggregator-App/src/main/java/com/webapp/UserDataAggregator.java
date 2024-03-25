package com.webapp;

import java.util.List;
import java.util.ArrayList;

public class UserDataAggregator {

    public static List<User> aggregateUserData(List<DataSourceConfig> dataSources) {
        List<User> users = new ArrayList<>();

        for (DataSourceConfig dataSourceConfig : dataSources) {
            users.addAll(UserDAO.queryDataSource(dataSourceConfig));
        }

        return users;
    }
}

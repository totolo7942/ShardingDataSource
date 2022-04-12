package com.example.shardingdatasource.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.security.SecureRandom;

public class MyRoutingDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        //DB random  choice 방식을 선택한다.
        SecureRandom random = new SecureRandom();
        int i = random.nextInt(2);
        if ( i % 2 == 0) {
            return "master";
        } else {
            return "replica";
        }
    }
}

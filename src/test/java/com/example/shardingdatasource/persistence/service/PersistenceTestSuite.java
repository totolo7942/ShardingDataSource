package com.example.shardingdatasource.persistence.service;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ // @formatter:off
    FooPaginationPersistenceIntegrationTest.class
    ,FooServicePersistenceIntegrationTest.class
    ,FooServiceSortingIntegrationTest.class
    ,FooServiceSortingWitNullsManualIntegrationTest.class
}) // @formatter:on
public class PersistenceTestSuite {
    //
}

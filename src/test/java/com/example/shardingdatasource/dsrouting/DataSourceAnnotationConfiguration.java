package com.example.shardingdatasource.dsrouting;

import com.example.shardingdatasource.mapper.MyMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@ExtendWith(SpringExtension.class)
@SpringBootTest
public class DataSourceAnnotationConfiguration {

    @Autowired
    private MyMapper myMapper;

    @Test
    void testUserRequestAnnotationDynamicDataSource(){
        final String currentDataBaseName = myMapper.selectDbName();
        assertEquals(currentDataBaseName, "myDb");
    }
}

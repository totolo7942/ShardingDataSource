package com.example.shardingdatasource.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
@MapperScan(value = "com.example.shardingdatasource.mapper")
public class DatabaseConfig {

    @Bean(name = "dbDataSource")
    public DataSource RouterDataSource() {
        Map<Object, Object> targetSources = new HashMap<>();
        targetSources.put("master", getMasterDataSource());
        targetSources.put("replica", getReplicaDataSource());

        MyRoutingDataSource dataSource = new MyRoutingDataSource();
        dataSource.setTargetDataSources(targetSources);
        return dataSource;
    }

    private DataSource getMasterDataSource() {
        com.zaxxer.hikari.HikariDataSource dataSource = new com.zaxxer.hikari.HikariDataSource();
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/myDb?autoReconnect=true&useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");
        return dataSource;
    }

    private DataSource getReplicaDataSource() {
        com.zaxxer.hikari.HikariDataSource dataSource = new com.zaxxer.hikari.HikariDataSource();
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/slaveMyDb?autoReconnect=true&useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");
        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(RouterDataSource());
        sessionFactoryBean.setConfigurationProperties(myBatisProperties());
        return sessionFactoryBean.getObject();
    }
    private Properties myBatisProperties() {
        Properties properties = new Properties();
        properties.put("lazyLoadingEnabled", "true");
        properties.put("jdbcTypeForNull", "NULL");
        return properties;
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager(){
        return new DataSourceTransactionManager(RouterDataSource());
    }
}
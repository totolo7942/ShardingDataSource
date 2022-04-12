package com.example.shardingdatasource.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MyMapper {
    @Select("SELECT DATABASE() FROM dual")
    String selectDbName();
}
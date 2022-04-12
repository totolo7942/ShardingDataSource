package com.example.shardingdatasource.inmemory.persistence.dao;

import com.example.shardingdatasource.persistence.model.ManyTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManyTagRepository extends JpaRepository<ManyTag, Long> {
}

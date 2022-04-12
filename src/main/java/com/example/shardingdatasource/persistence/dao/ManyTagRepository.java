package com.example.shardingdatasource.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.shardingdatasource.persistence.model.ManyTag;

public interface ManyTagRepository extends JpaRepository<ManyTag, Long> {
}

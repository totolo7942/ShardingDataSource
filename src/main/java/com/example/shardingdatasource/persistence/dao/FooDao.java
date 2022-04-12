package com.example.shardingdatasource.persistence.dao;

import org.springframework.stereotype.Repository;
import com.example.shardingdatasource.persistence.model.Foo;

@Repository
public class FooDao extends AbstractJpaDAO<Foo> implements IFooDao {

    public FooDao() {
        super();

        setClazz(Foo.class);
    }

    // API

}

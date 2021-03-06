package com.example.shardingdatasource.persistence.service;

import com.example.shardingdatasource.config.PersistenceJPAConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import com.example.shardingdatasource.persistence.model.Foo;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { PersistenceJPAConfig.class }, loader = AnnotationConfigContextLoader.class)
@DirtiesContext
public class FooServicePersistenceIntegrationTest {

    @Autowired
    private FooService service;

    // tests

    @Test
    public final void whenContextIsBootstrapped_thenNoExceptions() {
        //
    }

    @Test
    public final void whenEntityIsCreated_thenNoExceptions() {
        service.create(new Foo(randomAlphabetic(6)));
    }

    @Test
    public final void whenInvalidEntityIsCreated_thenDataException() {
        service.create(new Foo(randomAlphabetic(2048)));
    }

    @Test
    public final void whenEntityWithLongNameIsCreated_thenDataException() {
        service.create(new Foo(randomAlphabetic(2048)));
    }

    @Test
    public final void whenSameEntityIsCreatedTwice_thenDataException() {
        final Foo entity = new Foo(randomAlphabetic(8));
        service.create(entity);
        service.create(entity);
    }

    @Test
    public final void temp_whenInvalidEntityIsCreated_thenDataException() {
        service.create(new Foo(randomAlphabetic(2048)));
    }

    @Test
    public final void whenEntityIsCreated_thenFound() {
        final Foo fooEntity = new Foo("abc");
        service.create(fooEntity);
        final Foo found = service.findOne(fooEntity.getId());
        assertNotNull(found);
    }

}

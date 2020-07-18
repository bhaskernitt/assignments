package com.bhaskerstreet.task2.test;

import com.bhaskerstreet.task2.Task2Application;
import com.bhaskerstreet.task2.entities.DatabaseEntity;
import com.bhaskerstreet.task2.global.TestGlobalConstants;
import com.bhaskerstreet.task2.services.EntityRepositoryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

@ActiveProfiles(TestGlobalConstants.TEST_PROFILE)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = Task2Application.class, properties = TestGlobalConstants.PORT_PROPERTY)
public class TestRepositoryService {

    @Autowired
    private EntityRepositoryService entityRepositoryService;


    @Test
    public void testFetchOperation() {
        DatabaseEntity databaseEntity = new DatabaseEntity("100", "101", "testName", "testColor");
        List<DatabaseEntity> databaseEntities = new ArrayList<>();
        databaseEntities.add(databaseEntity);
        databaseEntities = entityRepositoryService.saveEntities(databaseEntities);

        DatabaseEntity fromDb = entityRepositoryService.findById(databaseEntities.get(0).getId());
        Assertions.assertEquals(fromDb.getColor(), "testColor");

        entityRepositoryService.deleteAll();
        fromDb = entityRepositoryService.findById(databaseEntities.get(0).getId());
        Assertions.assertNull(fromDb);

    }


}

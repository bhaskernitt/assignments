package com.bhaskerstreet.task2.test;

import com.bhaskerstreet.task2.Task2Application;
import com.bhaskerstreet.task2.entities.DatabaseEntity;
import com.bhaskerstreet.task2.global.TestGlobalConstants;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles(TestGlobalConstants.TEST_PROFILE)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = Task2Application.class, properties = TestGlobalConstants.PORT_PROPERTY)
public class TestModels {

    @Test
    public void testDatabaseEntity() {
        DatabaseEntity databaseEntity = new DatabaseEntity("1", "2", "test", "white");
        assertEquals(databaseEntity.getId(), 1);
        assertEquals(databaseEntity.getName(), "test");
        assertEquals(databaseEntity.getColor(), "white");
        assertEquals(databaseEntity.getParentId(), 2);

        databaseEntity.setId(2);
        databaseEntity.setColor("black");
        databaseEntity.setName("dummy");
        databaseEntity.setParentId(3);

        assertEquals(databaseEntity.getId(), 2);
        assertEquals(databaseEntity.getName(), "dummy");
        assertEquals(databaseEntity.getColor(), "black");
        assertEquals(databaseEntity.getParentId(), 3);

    }
}

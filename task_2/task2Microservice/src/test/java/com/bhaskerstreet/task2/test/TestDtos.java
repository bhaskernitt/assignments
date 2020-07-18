package com.bhaskerstreet.task2.test;

import com.bhaskerstreet.task2.Task2Application;
import com.bhaskerstreet.task2.dtos.Response;
import com.bhaskerstreet.task2.global.TestGlobalConstants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

@ActiveProfiles(TestGlobalConstants.TEST_PROFILE)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = Task2Application.class, properties = TestGlobalConstants.PORT_PROPERTY)
public class TestDtos {

    @Test
    public void testResponse() {
        Response response = new Response();
        Assertions.assertNotNull(response);
        Response childResponse = new Response();
        childResponse.setName("child");

        List<Response> subClasses = new ArrayList<>();
        subClasses.add(childResponse);

        response.setName("dummy");
        response.setSubClasses(subClasses);

        Assertions.assertEquals(response.getName(), "dummy");
        Assertions.assertEquals(response.getSubClasses().size(), 1);
        Assertions.assertEquals(response.getSubClasses().get(0).getName(), "child");


    }

}

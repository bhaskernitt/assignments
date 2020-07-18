package com.bhaskerstreet.microservice_3.test;

import com.bhaskerstreet.microservice_3.MicroService3Application;
import com.bhaskerstreet.microservice_3.dtos.PostRequestDTO;
import com.bhaskerstreet.microservice_3.global.TestGlobalConstants;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles(TestGlobalConstants.TEST_PROFILE)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = MicroService3Application.class, properties = TestGlobalConstants.PORT_PROPERTY)
public class TestDtos {


    @Test
    public void testPostRequestDTO() {
        PostRequestDTO postRequestDTO = new PostRequestDTO("james", "bond");
        assertEquals(postRequestDTO.getName(), "james");
        assertEquals(postRequestDTO.getSurname(), "bond");

        postRequestDTO.setName("money");
        postRequestDTO.setSurname("heist");

        assertEquals(postRequestDTO.getName(), "money");
        assertEquals(postRequestDTO.getSurname(), "heist");


    }
}

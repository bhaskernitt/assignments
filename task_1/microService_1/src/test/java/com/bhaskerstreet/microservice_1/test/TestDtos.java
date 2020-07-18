package com.bhaskerstreet.microservice_1.test;

import com.bhaskerstreet.microservice_1.MicroService1Application;
import com.bhaskerstreet.microservice_1.dtos.ConcatenatedResponse;
import com.bhaskerstreet.microservice_1.dtos.PostRequestDTO;
import com.bhaskerstreet.microservice_1.global.TestGlobalConstants;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles(TestGlobalConstants.TEST_PROFILE)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = MicroService1Application.class, properties = TestGlobalConstants.PORT_PROPERTY)
public class TestDtos {

    @Test
    public void testConcatenatedResponse() {
        ConcatenatedResponse concatenatedResponse = new ConcatenatedResponse("how are you?");
        assertEquals(concatenatedResponse.getMessage(), "how are you?");

        concatenatedResponse.setMessage("I'm fine");
        assertEquals(concatenatedResponse.getMessage(), "I'm fine");

    }

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

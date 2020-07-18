package com.bhaskerstreet.microservice_3.test;

import com.bhaskerstreet.microservice_3.MicroService3Application;
import com.bhaskerstreet.microservice_3.constants.ErrorResponse;
import com.bhaskerstreet.microservice_3.global.TestGlobalConstants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


@ActiveProfiles(TestGlobalConstants.TEST_PROFILE)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = MicroService3Application.class, properties = TestGlobalConstants.PORT_PROPERTY)
public class TestErrorResponse {

    @Test
    public void testErrorResponses() {
        Assertions.assertEquals(ErrorResponse.BAD_REQUEST.getCode(), "1001");
        Assertions.assertEquals(ErrorResponse.BAD_REQUEST.getMessage(), "BAD REQUEST");
        Assertions.assertEquals(ErrorResponse.BAD_REQUEST.getErrorUrl(), "https://bhaskerstreet.com/error/1001");

        Assertions.assertEquals(ErrorResponse.METHOD_NOT_SUPPORTED.getCode(), "1004");
        Assertions.assertEquals(ErrorResponse.METHOD_NOT_SUPPORTED.getMessage(), "Incorrect method selection for the resource");
        Assertions.assertEquals(ErrorResponse.METHOD_NOT_SUPPORTED.getErrorUrl(), "https://bhaskerstreet.com/error/1004");

        Assertions.assertEquals(ErrorResponse.INVALID_JSON.getCode(), "1005");
        Assertions.assertEquals(ErrorResponse.INVALID_JSON.getMessage(), "Invalid Json received");
        Assertions.assertEquals(ErrorResponse.INVALID_JSON.getErrorUrl(), "https://bhaskerstreet.com/error/1005");

    }
}

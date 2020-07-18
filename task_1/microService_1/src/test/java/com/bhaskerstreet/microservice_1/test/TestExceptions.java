package com.bhaskerstreet.microservice_1.test;

import com.bhaskerstreet.microservice_1.MicroService1Application;
import com.bhaskerstreet.microservice_1.exception.BadRequest;
import com.bhaskerstreet.microservice_1.exception.ErrorResponseDto;
import com.bhaskerstreet.microservice_1.exception.RootException;
import com.bhaskerstreet.microservice_1.global.TestGlobalConstants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;


@ActiveProfiles(TestGlobalConstants.TEST_PROFILE)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = MicroService1Application.class, properties = TestGlobalConstants.PORT_PROPERTY)
public class TestExceptions {

    @Test
    public void testErrorExceptions() {
        BadRequest badRequest = new BadRequest("test response", "http://abc.com/errors/1");
        Assertions.assertEquals(badRequest.getErrorUrl(), "http://abc.com/errors/1");
        Assertions.assertEquals(badRequest.getMessage(), "test response");
        Assertions.assertEquals(badRequest.getHttpStatus(), HttpStatus.BAD_REQUEST);


        ErrorResponseDto errorResponseDto = new ErrorResponseDto(HttpStatus.CONFLICT.value(), "Test", "http://abc.com/errors/1");
        Assertions.assertEquals(errorResponseDto.getErrorUrl(), "http://abc.com/errors/1");
        Assertions.assertEquals(errorResponseDto.getMessage(), "Test");
        Assertions.assertEquals(errorResponseDto.getHttpStatus(), HttpStatus.CONFLICT.value());

        errorResponseDto.setErrorUrl("http://abc.com/errors/2");
        errorResponseDto.setMessage("test new");
        errorResponseDto.setHttpStatus(HttpStatus.NOT_FOUND.value());

        Assertions.assertEquals(errorResponseDto.getErrorUrl(), "http://abc.com/errors/2");
        Assertions.assertEquals(errorResponseDto.getMessage(), "test new");
        Assertions.assertEquals(errorResponseDto.getHttpStatus(), HttpStatus.NOT_FOUND.value());

        RootException rootException = new RootException(HttpStatus.CONFLICT, "test", "http://abc.com/errors/1");
        Assertions.assertEquals(rootException.getErrorUrl(), "http://abc.com/errors/1");
        Assertions.assertEquals(rootException.getMessage(), "test");
        Assertions.assertEquals(rootException.getHttpStatus(), HttpStatus.CONFLICT);

    }
}

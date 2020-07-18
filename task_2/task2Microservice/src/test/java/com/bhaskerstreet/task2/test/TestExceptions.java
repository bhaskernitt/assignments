package com.bhaskerstreet.task2.test;

import com.bhaskerstreet.task2.Task2Application;
import com.bhaskerstreet.task2.exception.BadRequest;
import com.bhaskerstreet.task2.exception.ErrorResponseDto;
import com.bhaskerstreet.task2.exception.NoImplementationException;
import com.bhaskerstreet.task2.exception.RootException;
import com.bhaskerstreet.task2.global.TestGlobalConstants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;


@ActiveProfiles(TestGlobalConstants.TEST_PROFILE)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = Task2Application.class, properties = TestGlobalConstants.PORT_PROPERTY)
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


        RootException rootException = new RootException(HttpStatus.CONFLICT, "test", "http://abc.com/errors/1");
        Assertions.assertEquals(rootException.getErrorUrl(), "http://abc.com/errors/1");
        Assertions.assertEquals(rootException.getMessage(), "test");
        Assertions.assertEquals(rootException.getHttpStatus(), HttpStatus.CONFLICT);

        NoImplementationException noImplementationException = new NoImplementationException("impl not available");
        Assertions.assertEquals(noImplementationException.getMessage(), "impl not available");
    }
}

package com.bhaskerstreet.microservice_2.test.integartionTests;

import com.bhaskerstreet.microservice_2.MicroService2Application;
import com.bhaskerstreet.microservice_2.config.TestHttpRequest;
import com.bhaskerstreet.microservice_2.constants.ResponseMessages;
import com.bhaskerstreet.microservice_2.global.TestAbstract;
import com.bhaskerstreet.microservice_2.global.TestGlobalConstants;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles(TestGlobalConstants.TEST_PROFILE)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = MicroService2Application.class, properties = TestGlobalConstants.PORT_PROPERTY)
public class TestApi extends TestAbstract {

    @Test
    public void testGet() {
        ResponseEntity<String> responseEntity = TestHttpRequest.
                processRequest(HOST + "/", null, HttpMethod.GET, String.class);
        System.out.println();
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(responseEntity.getBody(), ResponseMessages.HELLO.getMessage());
    }

}

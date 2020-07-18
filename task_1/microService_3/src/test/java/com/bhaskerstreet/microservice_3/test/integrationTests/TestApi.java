package com.bhaskerstreet.microservice_3.test.integrationTests;


import com.bhaskerstreet.microservice_3.MicroService3Application;
import com.bhaskerstreet.microservice_3.config.TestHttpRequest;
import com.bhaskerstreet.microservice_3.global.TestAbstract;
import com.bhaskerstreet.microservice_3.global.TestGlobalConstants;
import com.bhaskerstreet.microservice_3.global.TestRequests;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles(TestGlobalConstants.TEST_PROFILE)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = MicroService3Application.class, properties = TestGlobalConstants.PORT_PROPERTY)
public class TestApi extends TestAbstract {

    @Test
    public void testPost() {
        ResponseEntity<String> responseEntity = TestHttpRequest.
                processRequest(HOST + "/", TestRequests.REQUEST_PAYLOAD, HttpMethod.POST, String.class);
        System.out.println();
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(responseEntity.getBody(), "james bond");
    }

}

package com.bhaskerstreet.microservice_1.test.integartionTests;

import com.bhaskerstreet.microservice_1.MicroService1Application;
import com.bhaskerstreet.microservice_1.client.http.HttpClient;
import com.bhaskerstreet.microservice_1.client.http.service.HttpService;
import com.bhaskerstreet.microservice_1.config.TestHttpRequest;
import com.bhaskerstreet.microservice_1.constants.ApplicationStatuses;
import com.bhaskerstreet.microservice_1.constants.ErrorResponse;
import com.bhaskerstreet.microservice_1.exception.HttpRequestException;
import com.bhaskerstreet.microservice_1.global.TestAbstract;
import com.bhaskerstreet.microservice_1.global.TestGlobalConstants;
import com.bhaskerstreet.microservice_1.global.TestRequests;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ActiveProfiles(TestGlobalConstants.TEST_PROFILE)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = MicroService1Application.class, properties = TestGlobalConstants.PORT_PROPERTY)
public class TestApi extends TestAbstract {

    @Autowired
    private HttpService httpService;

    @Test
    public void testGet() {
        ResponseEntity<String> responseEntity = TestHttpRequest.
                processRequest(HOST + "/", null, HttpMethod.GET, String.class);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        assertEquals(responseEntity.getBody(), ApplicationStatuses.UP.getStatus());
    }

    @Test
    public void testIfService2or3NotAvailable() throws Exception {
        HttpRequestException exception = assertThrows(HttpRequestException.class, () -> {

            HttpClient.resources(httpService)
                    .get("http://localhost:9999", String.class);
        });

        JSONAssert.assertEquals(exception.getMessage(), ErrorResponse.COMMUNICATION_FAILURE.getMessage(), false);
        assertEquals(exception.getHttpStatus(), HttpStatus.SERVICE_UNAVAILABLE);
        testPost();
    }


    public void testPost() {
        ResponseEntity<String> responseEntity = TestHttpRequest.
                processRequest(HOST, TestRequests.REQUEST_PAYLOAD, HttpMethod.POST, String.class);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);

    }


}

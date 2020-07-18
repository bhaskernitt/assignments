package com.bhaskerstreet.task2.test.integartionTests;


import com.bhaskerstreet.task2.Task2Application;
import com.bhaskerstreet.task2.config.TestHttpRequest;
import com.bhaskerstreet.task2.global.TestAbstract;
import com.bhaskerstreet.task2.global.TestApiResponses;
import com.bhaskerstreet.task2.global.TestGlobalConstants;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ActiveProfiles(TestGlobalConstants.TEST_PROFILE)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = Task2Application.class, properties = TestGlobalConstants.PORT_PROPERTY)
public class TestApi extends TestAbstract {

    @Test
    public void testRecords() throws Exception {
        ResponseEntity<String> responseEntity = TestHttpRequest.
                processRequest(HOST + "/v1/records", null, HttpMethod.GET, String.class);
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        JSONAssert.assertEquals(responseEntity.getBody(), TestApiResponses.GET_RECORDS, false);
    }


    @Test
    public void testRecordByIdNotFound() throws Exception {

        HttpClientErrorException exception = assertThrows(org.springframework.web.client.HttpClientErrorException.class, () -> {
            TestHttpRequest.
                    processRequest(HOST + "/v1/records/100", null, HttpMethod.GET, String.class);
        });

        JSONAssert.assertEquals(exception.getResponseBodyAsString(), TestApiResponses.RECORD_NOT_FOUND, false);
        Assert.assertEquals(exception.getRawStatusCode(), HttpStatus.NOT_FOUND.value());

    }

    @Test
    public void testRecordById_1() throws Exception {
        ResponseEntity<String> responseEntity = TestHttpRequest.
                processRequest(HOST + "/v1/records/1", null, HttpMethod.GET, String.class);
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        JSONAssert.assertEquals(responseEntity.getBody(), TestApiResponses.RECORD_BY_ID_1, false);

    }

    @Test
    public void testRecordById_2() throws Exception {
        ResponseEntity<String> responseEntity = TestHttpRequest.
                processRequest(HOST + "/v1/records/2", null, HttpMethod.GET, String.class);
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        JSONAssert.assertEquals(responseEntity.getBody(), TestApiResponses.RECORD_BY_ID_2, false);

    }

    @Test
    public void testRecordById_3() throws Exception {
        ResponseEntity<String> responseEntity = TestHttpRequest.
                processRequest(HOST + "/v1/records/3", null, HttpMethod.GET, String.class);
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        JSONAssert.assertEquals(responseEntity.getBody(), TestApiResponses.RECORD_BY_ID_3, false);

    }

    @Test
    public void testRecordById_4() throws Exception {
        ResponseEntity<String> responseEntity = TestHttpRequest.
                processRequest(HOST + "/v1/records/4", null, HttpMethod.GET, String.class);
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        JSONAssert.assertEquals(responseEntity.getBody(), TestApiResponses.RECORD_BY_ID_4, false);

    }

    @Test
    public void testRecordById_5() throws Exception {
        ResponseEntity<String> responseEntity = TestHttpRequest.
                processRequest(HOST + "/v1/records/5", null, HttpMethod.GET, String.class);
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        JSONAssert.assertEquals(responseEntity.getBody(), TestApiResponses.RECORD_BY_ID_5, false);

    }
}

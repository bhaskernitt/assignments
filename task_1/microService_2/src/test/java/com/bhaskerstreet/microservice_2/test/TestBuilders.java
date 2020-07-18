package com.bhaskerstreet.microservice_2.test;

import com.bhaskerstreet.microservice_2.MicroService2Application;
import com.bhaskerstreet.microservice_2.builder.HttpRequest;
import com.bhaskerstreet.microservice_2.global.TestGlobalConstants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles(TestGlobalConstants.TEST_PROFILE)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = MicroService2Application.class, properties = TestGlobalConstants.PORT_PROPERTY)
public class TestBuilders {

    @Test
    public void testBuilders() {
        HttpEntity<?> httpEntity = new HttpRequest.RequestBuilder()
                .setBody("{\"key\":\"value\"}")
                .setHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                .build();

        Assertions.assertEquals(httpEntity.getHeaders().size(), 1);
        Assertions.assertEquals(httpEntity.getHeaders().getContentType().toString(), MediaType.APPLICATION_JSON_VALUE);
        Assertions.assertEquals(httpEntity.getBody(), "{\"key\":\"value\"}");
    }


}

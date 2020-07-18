package com.bhaskerstreet.microservice_1.test;

import com.bhaskerstreet.microservice_1.MicroService1Application;
import com.bhaskerstreet.microservice_1.constants.GlobalConstants;
import com.bhaskerstreet.microservice_1.global.TestGlobalConstants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles(TestGlobalConstants.TEST_PROFILE)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = MicroService1Application.class, properties = TestGlobalConstants.PORT_PROPERTY)
public class TestConstants {

    @Test
    public void testConstants() {
        Assertions.assertEquals(GlobalConstants.APPLICATION_2_BASE_URL_KEY, "custom.application2.base.url");
        Assertions.assertEquals(GlobalConstants.APPLICATION_3_BASE_URL_KEY, "custom.application3.base.url");

    }
}

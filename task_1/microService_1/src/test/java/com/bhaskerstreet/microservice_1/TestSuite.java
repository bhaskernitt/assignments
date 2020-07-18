package com.bhaskerstreet.microservice_1;

import com.bhaskerstreet.microservice_1.global.TestGlobalConstants;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles(TestGlobalConstants.TEST_PROFILE)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = MicroService1Application.class, properties = TestGlobalConstants.PORT_PROPERTY)
@SelectPackages({"com.bhaskerstreet.microservice_1.test"})
@RunWith(JUnitPlatform.class)
public class TestSuite {

}

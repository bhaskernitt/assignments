package com.bhaskerstreet.microservice_2;


import com.bhaskerstreet.microservice_2.global.TestGlobalConstants;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = MicroService2Application.class, properties = TestGlobalConstants.PORT_PROPERTY)
@SelectPackages({"com.bhaskerstreet.microservice_2.test"})
@RunWith(JUnitPlatform.class)
public class TestSuite {

}

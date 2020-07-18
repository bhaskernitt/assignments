package com.bhaskerstreet.task2;

import com.bhaskerstreet.task2.global.TestGlobalConstants;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = Task2Application.class, properties = TestGlobalConstants.PORT_PROPERTY)
@SelectPackages({"com.bhaskerstreet.task2.test"})
@RunWith(JUnitPlatform.class)
public class TestSuite {

}

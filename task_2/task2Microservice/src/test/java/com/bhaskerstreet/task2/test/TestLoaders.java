package com.bhaskerstreet.task2.test;

import com.bhaskerstreet.task2.Task2Application;
import com.bhaskerstreet.task2.global.TestGlobalConstants;
import com.bhaskerstreet.task2.loader.Loader;
import com.bhaskerstreet.task2.loader.fileLoader.FileLoader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ActiveProfiles(TestGlobalConstants.TEST_PROFILE)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = Task2Application.class, properties = TestGlobalConstants.PORT_PROPERTY)
public class TestLoaders {

    @Test
    public void testFileLoader() throws IOException {
        Loader loader = new FileLoader("/testFile");
        Assertions.assertEquals(loader.load(), "data");
    }

    @Test
    public void testExceptionFileLoader() {

        Exception exception = assertThrows(NullPointerException.class, () -> {
            new FileLoader("/dummy").load();
        });
        assertTrue(exception instanceof NullPointerException);

    }
}

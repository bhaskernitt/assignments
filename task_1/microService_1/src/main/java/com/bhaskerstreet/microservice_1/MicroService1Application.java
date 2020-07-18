package com.bhaskerstreet.microservice_1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(scanBasePackages = "com.bhaskerstreet.microservice_1.**")
@EnableWebMvc
public class MicroService1Application implements ApplicationRunner {

    private static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        SpringApplication.run(MicroService1Application.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        logger.info("Application started");
    }
}

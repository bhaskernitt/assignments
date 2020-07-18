package com.bhaskerstreet.microservice_3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(scanBasePackages = "com.bhaskerstreet.microservice_3.**")
@EnableWebMvc
public class MicroService3Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroService3Application.class, args);
    }

}

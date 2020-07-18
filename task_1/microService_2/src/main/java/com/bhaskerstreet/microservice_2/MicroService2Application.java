package com.bhaskerstreet.microservice_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class MicroService2Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroService2Application.class, args);
    }

}

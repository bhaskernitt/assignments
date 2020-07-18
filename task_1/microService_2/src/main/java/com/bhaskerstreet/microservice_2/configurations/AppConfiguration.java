package com.bhaskerstreet.microservice_2.configurations;

import com.bhaskerstreet.microservice_2.constants.GlobalConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfiguration {

    private static Environment environment;

    @Autowired
    public AppConfiguration(Environment environment) {
        this.environment = environment;
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static String getAppBaseUrl() {
        return environment.getProperty(GlobalConstants.APP_URL);
    }

    public static String getAppErrorBaseUrl() {
        return environment.getProperty(GlobalConstants.APP_ERROR_URL);
    }
}

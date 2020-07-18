package com.bhaskerstreet.microservice_1.configuration;

import com.bhaskerstreet.microservice_1.constants.GlobalConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    private static Environment environment;

    @Autowired
    public AppConfig(Environment environment) {
        this.environment = environment;
    }

    public static String getProperty(String key) {
        return environment.getProperty(key);
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

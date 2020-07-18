package com.bhaskerstreet.microservice_1.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Profile({"development"})
/**
 * swagger information will only be accessible in development profile, due to security reasons
 */
public class SwaggerConfig {

    public static final Contact DEFAULT_CONTACT = new Contact(
            "developer", "https://www.bhaskerstreet.com", "bhasker.nandkishor@gmail.com");

    public static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
            "Assignment microservice 1", "Assignment microservice 1", "1.0",
            "urn:tos", DEFAULT_CONTACT,
            "https://www.bhaskerstreet.com", "https://www.bhaskerstreet.com");

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEFAULT_API_INFO);
    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
                registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
            }
        };
    }
}
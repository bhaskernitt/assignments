package com.bhaskerstreet.microservice_1.processors;

import com.bhaskerstreet.microservice_1.builder.HttpRequest;
import com.bhaskerstreet.microservice_1.client.http.HttpClient;
import com.bhaskerstreet.microservice_1.client.http.service.HttpService;
import com.bhaskerstreet.microservice_1.client.http.service.response.concatenator.Response;
import com.bhaskerstreet.microservice_1.configuration.AppConfig;
import com.bhaskerstreet.microservice_1.constants.ApplicationStatuses;
import com.bhaskerstreet.microservice_1.constants.GlobalConstants;
import com.bhaskerstreet.microservice_1.dtos.ConcatenatedResponse;
import com.bhaskerstreet.microservice_1.dtos.PostRequestDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RootProcessorImpl implements RootProcessor {


    private static Logger logger = LogManager.getLogger(RootProcessorImpl.class);
    private final HttpService<String> httpService;

    @Autowired
    public RootProcessorImpl(HttpService<String> httpService) {
        this.httpService = httpService;
    }

    @Override
    public ResponseEntity<String> processGet() {
        return ResponseEntity.ok(ApplicationStatuses.UP.getStatus());
    }

    @Override
    public ResponseEntity<ConcatenatedResponse> processPost(PostRequestDTO postRequestDTO) throws Exception {
        logger.info("request received at controller");

        return ResponseEntity.ok(
                new Response.ResponseConcatenator(
                        HttpClient.resources(httpService)
                                .get(AppConfig.getProperty(GlobalConstants.APPLICATION_2_BASE_URL_KEY), String.class)
                        , HttpClient.resources(httpService)
                        .create(AppConfig.getProperty(GlobalConstants.APPLICATION_3_BASE_URL_KEY),
                                new HttpRequest.RequestBuilder()
                                        .setBody(postRequestDTO)
                                        .setHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                                        .build(),
                                String.class))
                        .concatenate());
    }
}

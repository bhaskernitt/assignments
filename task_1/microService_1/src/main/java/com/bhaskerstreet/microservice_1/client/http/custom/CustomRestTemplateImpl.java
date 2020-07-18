package com.bhaskerstreet.microservice_1.client.http.custom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomRestTemplateImpl<T> implements CustomRestTemplate<T> {


    private final RestTemplate restTemplate;

    @Autowired
    public CustomRestTemplateImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ResponseEntity<T> send(String url, HttpMethod httpMethod, HttpEntity httpEntity, Class<T> responseType, Object... uriVariables) {
        return restTemplate.exchange(url, httpMethod, httpEntity, responseType, uriVariables);
    }

}

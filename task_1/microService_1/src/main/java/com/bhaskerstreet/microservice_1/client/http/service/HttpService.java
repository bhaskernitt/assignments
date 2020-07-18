package com.bhaskerstreet.microservice_1.client.http.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface HttpService<T> {

    ResponseEntity<T> send(String url, HttpMethod httpMethod, HttpEntity httpEntity, Class<T> responseType, Object... uriVariables) throws Exception;
}

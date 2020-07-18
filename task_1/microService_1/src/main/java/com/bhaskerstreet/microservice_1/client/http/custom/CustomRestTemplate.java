package com.bhaskerstreet.microservice_1.client.http.custom;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface CustomRestTemplate<T> {

    ResponseEntity<T> send(String url, HttpMethod httpMethod, HttpEntity requestEntity, Class<T> responseType, Object... uriVariables);
}

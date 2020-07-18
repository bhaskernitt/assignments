package com.bhaskerstreet.microservice_1.client.http.apiActions;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

public interface Actions<T> {

    ResponseEntity<T> get(String url, Class<T> responseType, Object... uriVariables) throws Exception;

    ResponseEntity<T> create(String url, HttpEntity httpEntity, Class<T> responseType, Object... uriVariables) throws Exception;

}

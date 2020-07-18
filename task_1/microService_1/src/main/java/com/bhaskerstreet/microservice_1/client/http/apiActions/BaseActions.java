package com.bhaskerstreet.microservice_1.client.http.apiActions;

import com.bhaskerstreet.microservice_1.client.http.service.HttpService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

public abstract class BaseActions<T> implements Actions {

    private final HttpService<T> httpService;


    public BaseActions(HttpService httpService) {
        this.httpService = httpService;
    }

    private ResponseEntity<T> processGet(String url, Class<T> responseType, Object... uriVariables) throws Exception {
        return httpService.send(url, HttpMethod.GET, null, responseType, uriVariables);
    }

    private ResponseEntity<T> processPost(String url, HttpEntity httpEntity, Class<T> responseType, Object... uriVariables) throws Exception {

        return httpService.send(url, HttpMethod.POST, httpEntity, responseType, uriVariables);
    }

    @Override
    public ResponseEntity get(String url, Class responseType, Object... uriVariables) throws Exception {
        return processGet(url, responseType, uriVariables);
    }

    @Override
    public ResponseEntity create(String url, HttpEntity httpEntity, Class responseType, Object... uriVariables) throws Exception {
        return processPost(url, httpEntity, responseType, uriVariables);
    }
}

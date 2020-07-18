package com.bhaskerstreet.task2.config;


import com.bhaskerstreet.task2.builder.HttpRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class TestHttpRequest {


    private TestHttpRequest() {
    }

    public static HttpEntity prepareRequestEntity(Object body, String cType) {
        return new HttpRequest.RequestBuilder()
                .setHeader("Content-Type", cType)
                .setBody(body)
                .build();
    }

    public static ResponseEntity processRequest(String url, String request, HttpMethod httpMethod, Class responseType, String... uriVariables) {

        HttpEntity httpEntity = prepareRequestEntity(request, MediaType.APPLICATION_JSON_VALUE);

        return new TestHttpRequest.TestHttpRequestBuilder()
                .sendRequest(url
                        , httpMethod
                        , httpEntity
                        , responseType
                        , uriVariables);
    }


    public static class TestHttpRequestBuilder {

        public ResponseEntity sendRequest(String url, HttpMethod method, HttpEntity<?> requestEntity, Class responseType, Object... uriVariables) {
            RestTemplate restTemplate = new RestTemplate();
            return restTemplate.exchange(url, method, requestEntity, responseType, uriVariables);
        }
    }


}

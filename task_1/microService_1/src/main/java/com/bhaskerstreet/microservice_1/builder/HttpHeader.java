package com.bhaskerstreet.microservice_1.builder;

import org.springframework.http.HttpHeaders;

public class HttpHeader {


    public static HttpHeaders getHttpHeaderInstance() {
        return new HttpHeaders();
    }


}

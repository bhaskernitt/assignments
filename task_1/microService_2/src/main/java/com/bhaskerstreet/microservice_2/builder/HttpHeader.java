package com.bhaskerstreet.microservice_2.builder;

import org.springframework.http.HttpHeaders;

public class HttpHeader {


    public static HttpHeaders getHttpHeaderInstance() {
        return new HttpHeaders();
    }


}

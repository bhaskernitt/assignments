package com.bhaskerstreet.microservice_1.builder;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;


public class HttpRequest<T> {

    private HttpRequest() {
    }

    public static class RequestBuilder<T> {

        private HttpHeaders httpHeader;
        private T body;

        public RequestBuilder() {
            this.httpHeader = HttpHeader.getHttpHeaderInstance();
        }


        public RequestBuilder setHeader(String key, String value) {
            this.httpHeader.set(key, value);
            return this;
        }


        public RequestBuilder setBody(T body) {
            this.body = body;
            return this;
        }


        public HttpEntity<?> build() {
            return new HttpEntity<>(this.body, this.httpHeader);
        }

    }
}

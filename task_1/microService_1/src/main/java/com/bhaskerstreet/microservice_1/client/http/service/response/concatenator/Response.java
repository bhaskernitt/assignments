package com.bhaskerstreet.microservice_1.client.http.service.response.concatenator;

import com.bhaskerstreet.microservice_1.dtos.ConcatenatedResponse;
import org.springframework.http.ResponseEntity;

public class Response {

    public static class ResponseConcatenator {

        private ResponseEntity responseEntity2;
        private ResponseEntity responseEntity3;

        public ResponseConcatenator(ResponseEntity responseEntity2, ResponseEntity responseEntity3) {
            this.responseEntity2 = responseEntity2;
            this.responseEntity3 = responseEntity3;
        }

        public ConcatenatedResponse concatenate() {
            return new ConcatenatedResponse(responseEntity2.getBody() + " " + responseEntity3.getBody());
        }

    }
}

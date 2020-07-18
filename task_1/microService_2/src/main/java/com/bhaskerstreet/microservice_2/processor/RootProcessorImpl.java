package com.bhaskerstreet.microservice_2.processor;


import com.bhaskerstreet.microservice_2.constants.ResponseMessages;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RootProcessorImpl implements RootProcessor {


    @Override
    public ResponseEntity<String> processGet() {
        return ResponseEntity.ok(ResponseMessages.HELLO.getMessage());
    }

}

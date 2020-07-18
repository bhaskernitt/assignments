package com.bhaskerstreet.microservice_2.processor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface RootProcessor {

    ResponseEntity<String> processGet();
}

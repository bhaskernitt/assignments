package com.bhaskerstreet.microservice_3.processor;

import com.bhaskerstreet.microservice_3.dtos.PostRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface RootProcessor {

    ResponseEntity processPost(PostRequestDTO postRequestDTO);
}

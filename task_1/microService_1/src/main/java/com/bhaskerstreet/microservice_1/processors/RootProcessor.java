package com.bhaskerstreet.microservice_1.processors;

import com.bhaskerstreet.microservice_1.dtos.ConcatenatedResponse;
import com.bhaskerstreet.microservice_1.dtos.PostRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface RootProcessor {

    ResponseEntity<String> processGet() throws Exception;

    ResponseEntity<ConcatenatedResponse> processPost(PostRequestDTO postRequestDTO) throws Exception;
}

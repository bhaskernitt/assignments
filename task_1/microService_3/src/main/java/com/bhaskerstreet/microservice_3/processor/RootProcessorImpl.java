package com.bhaskerstreet.microservice_3.processor;

import com.bhaskerstreet.microservice_3.dtos.PostRequestDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RootProcessorImpl implements RootProcessor {


    private static Logger logger = LogManager.getLogger(com.bhaskerstreet.microservice_3.processor.RootProcessorImpl.class);

    @Override
    public ResponseEntity processPost(PostRequestDTO postRequestDTO) {
        logger.info("request rcv at controller");


        return ResponseEntity.ok(postRequestDTO.getName() + " " + postRequestDTO.getSurname());
    }
}

package com.bhaskerstreet.task2.processors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface RootProcessor {

    ResponseEntity processFetchAll();

    ResponseEntity processFetchById(Integer id) throws Exception;
}

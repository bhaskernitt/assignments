package com.bhaskerstreet.task2.services;

import com.bhaskerstreet.task2.dtos.Response;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NestedResponseGeneratorService {

    List<Response> generateNestedJson();
}

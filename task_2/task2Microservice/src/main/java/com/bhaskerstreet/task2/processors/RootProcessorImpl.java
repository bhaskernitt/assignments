package com.bhaskerstreet.task2.processors;

import com.bhaskerstreet.task2.annotations.LogMethodParam;
import com.bhaskerstreet.task2.constants.ErrorResponse;
import com.bhaskerstreet.task2.dtos.Response;
import com.bhaskerstreet.task2.entities.DatabaseEntity;
import com.bhaskerstreet.task2.exception.NotFound;
import com.bhaskerstreet.task2.services.EntityRepositoryService;
import com.bhaskerstreet.task2.services.NestedResponseGeneratorService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RootProcessorImpl implements RootProcessor {

    private static Logger logger = LogManager.getLogger(com.bhaskerstreet.task2.processors.RootProcessor.class);

    private final EntityRepositoryService entityRepositoryService;
    private final NestedResponseGeneratorService nestedResponseGeneratorService;


    @Autowired
    public RootProcessorImpl(EntityRepositoryService entityRepositoryService, NestedResponseGeneratorService nestedResponseGeneratorService) {
        this.entityRepositoryService = entityRepositoryService;
        this.nestedResponseGeneratorService = nestedResponseGeneratorService;
    }


    @Override
    @LogMethodParam(printMethodOutput = true)
    public ResponseEntity<List<Response>> processFetchAll() {
        logger.info("request rcv at controller");
        return ResponseEntity.ok(nestedResponseGeneratorService.generateNestedJson());
    }

    @Override
    public ResponseEntity processFetchById(Integer id) throws Exception {

        DatabaseEntity databaseEntity = entityRepositoryService.findById(id);
        Response finalResponse = null;
        if (null == databaseEntity) {
            throw new NotFound(ErrorResponse.NOT_FOUND.resolveMessage(String.valueOf(id)), ErrorResponse.NOT_FOUND.getErrorUrl());

        }
        List<Response> fetchAll = processFetchAll().getBody();

        for (Response response : fetchAll) {
            if (response.getName().equals(databaseEntity.getName())) {
                finalResponse = response;
            }
        }
        if (finalResponse == null) {
            finalResponse = new Response();
            finalResponse.setName(databaseEntity.getName());
        }

        return ResponseEntity.ok(finalResponse);
    }
}

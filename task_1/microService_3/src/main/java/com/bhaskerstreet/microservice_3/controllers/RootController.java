package com.bhaskerstreet.microservice_3.controllers;


import com.bhaskerstreet.microservice_3.annotations.LogMethodParam;
import com.bhaskerstreet.microservice_3.constants.ApiDocConstants;
import com.bhaskerstreet.microservice_3.dtos.PostRequestDTO;
import com.bhaskerstreet.microservice_3.processor.RootProcessor;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = ApiDocConstants.CONTROLLER_GROUP, protocols = "http", description = "handles all Requests")
public class RootController extends AbstractBaseController {


    private final RootProcessor rootProcessor;

    @Autowired
    public RootController(RootProcessor rootProcessor) {
        this.rootProcessor = rootProcessor;
    }


    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @LogMethodParam
    @ApiOperation(httpMethod = "POST", value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, notes = "handles Post request on /")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 200, message = "Hello")})
    public ResponseEntity post(@RequestBody PostRequestDTO postRequestDTO) {

        return rootProcessor.processPost(postRequestDTO);
    }


}

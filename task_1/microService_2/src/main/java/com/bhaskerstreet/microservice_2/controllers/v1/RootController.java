package com.bhaskerstreet.microservice_2.controllers.v1;


import com.bhaskerstreet.microservice_2.annotations.LogMethodParam;
import com.bhaskerstreet.microservice_2.constants.ApiDocConstants;
import com.bhaskerstreet.microservice_2.controllers.AbstractBaseController;
import com.bhaskerstreet.microservice_2.processor.RootProcessor;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = ApiDocConstants.CONTROLLER_GROUP, protocols = "http", description = "handles all Requests")
public class RootController extends AbstractBaseController {

    private final RootProcessor rootProcessor;


    @Autowired
    public RootController(RootProcessor rootProcessor) {
        this.rootProcessor = rootProcessor;
    }

    @GetMapping(value = "/", consumes = MediaType.ALL_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    @LogMethodParam
    @ApiOperation(httpMethod = "GET", value = "/", produces = MediaType.TEXT_PLAIN_VALUE, consumes = MediaType.ALL_VALUE, notes = "handles get request on /")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 200, message = "Hello")})
    public ResponseEntity<String> get() {

        return rootProcessor.processGet();
    }


}

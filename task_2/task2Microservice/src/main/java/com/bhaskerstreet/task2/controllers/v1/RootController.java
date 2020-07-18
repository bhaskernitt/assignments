package com.bhaskerstreet.task2.controllers.v1;


import com.bhaskerstreet.task2.annotations.LogMethodParam;
import com.bhaskerstreet.task2.constants.ApiDocConstants;
import com.bhaskerstreet.task2.controllers.AbstractBaseController;
import com.bhaskerstreet.task2.processors.RootProcessor;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = ApiDocConstants.CONTROLLER_GROUP, protocols = "http", description = "handles all Requests")
public class RootController extends AbstractBaseController {

    private final RootProcessor rootProcessor;

    @Autowired
    public RootController(RootProcessor rootProcessor) {
        this.rootProcessor = rootProcessor;
    }


    @GetMapping(value = "/v1/records", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @LogMethodParam(printMethodOutput = true)
    @ApiOperation(httpMethod = "GET", value = "/v1/records", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, notes = "handles get request on /v1/records")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 200, message = "Up")})
    public ResponseEntity fetchAll() {

        return rootProcessor.processFetchAll();
    }

    @GetMapping(value = "/v1/records/{id}", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @LogMethodParam
    @ApiOperation(httpMethod = "GET", value = "/v1/records/{id}", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, notes = "handles get request on /v1/records/{id}")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 200, message = "Up")})
    public ResponseEntity fetch(@PathVariable Integer id) throws Exception {

        return rootProcessor.processFetchById(id);
    }
}

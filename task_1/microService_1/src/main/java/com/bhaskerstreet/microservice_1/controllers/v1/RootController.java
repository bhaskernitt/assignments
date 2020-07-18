package com.bhaskerstreet.microservice_1.controllers.v1;


import com.bhaskerstreet.microservice_1.annotations.LogMethodParam;
import com.bhaskerstreet.microservice_1.constants.ApiDocConstants;
import com.bhaskerstreet.microservice_1.controllers.AbstractBaseController;
import com.bhaskerstreet.microservice_1.dtos.ConcatenatedResponse;
import com.bhaskerstreet.microservice_1.dtos.PostRequestDTO;
import com.bhaskerstreet.microservice_1.processors.RootProcessor;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping(value = "/", consumes = MediaType.ALL_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    @LogMethodParam
    @ApiOperation(httpMethod = "GET", value = "/", consumes = MediaType.ALL_VALUE, produces = MediaType.TEXT_PLAIN_VALUE, notes = "handles get request on /")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 200, message = "Up")})
    public ResponseEntity<String> get() throws Exception {

        return rootProcessor.processGet();
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @LogMethodParam
    @ApiOperation(httpMethod = "POST", value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, notes = "handles POST request on /")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 200, message = "hello {firstName} {lastName}")})
    public ResponseEntity<ConcatenatedResponse> post(@RequestBody PostRequestDTO postRequestDTO) throws Exception {

        return rootProcessor.processPost(postRequestDTO);
    }
}

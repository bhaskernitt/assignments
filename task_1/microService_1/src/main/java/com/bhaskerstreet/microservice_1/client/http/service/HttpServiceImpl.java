package com.bhaskerstreet.microservice_1.client.http.service;

import com.bhaskerstreet.microservice_1.annotations.LogMethodParam;
import com.bhaskerstreet.microservice_1.client.http.custom.CustomRestTemplate;
import com.bhaskerstreet.microservice_1.constants.ErrorResponse;
import com.bhaskerstreet.microservice_1.exception.HttpRequestException;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.ResourceAccessException;


@Service
public class HttpServiceImpl<T> implements HttpService<T> {

    private static final Logger LOGGER = LogManager.getLogger(HttpServiceImpl.class);
    private final CustomRestTemplate<T> customRestTemplate;

    @Autowired
    public HttpServiceImpl(CustomRestTemplate<T> customRestTemplate) {
        this.customRestTemplate = customRestTemplate;
    }

    @Override
    @LogMethodParam
    public ResponseEntity<T> send(String url, HttpMethod httpMethod, HttpEntity requestEntity, Class<T> responseType, Object... uriVariables) throws Exception {

        ResponseEntity responseEntity;
        try {
            responseEntity = customRestTemplate.send(url, httpMethod, requestEntity, responseType, uriVariables);
        } catch (HttpStatusCodeException e) {
            LOGGER.error("http request sent: url:" + url + "error occured while making  http call: " + e.getResponseBodyAsString() + org.apache.commons.lang3.exception.ExceptionUtils.getStackTrace(e));
            throw new HttpRequestException(ErrorResponse.ERROR_OCCURRED_IN_DOWN_STREAM.getMessage());

        } catch (ResourceAccessException e) {
            LOGGER.error("http request sent: url:" + url + "error occured while making  http call: " + ExceptionUtils.getStackTrace(e));
            throw new HttpRequestException(ErrorResponse.COMMUNICATION_FAILURE.getMessage());
        }

        LOGGER.info(" http (api request ) request sent: url: " + url + " Processed Successfully");
        return responseEntity;

    }


}

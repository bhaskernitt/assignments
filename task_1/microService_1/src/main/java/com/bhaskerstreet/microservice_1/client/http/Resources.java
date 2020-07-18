package com.bhaskerstreet.microservice_1.client.http;

import com.bhaskerstreet.microservice_1.client.http.apiActions.BaseActions;
import com.bhaskerstreet.microservice_1.client.http.service.HttpService;

public class Resources<T> extends BaseActions<T> {


    public Resources(HttpService<T> httpService) {
        super(httpService);

    }
}

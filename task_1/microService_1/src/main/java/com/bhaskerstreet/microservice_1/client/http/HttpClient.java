package com.bhaskerstreet.microservice_1.client.http;

import com.bhaskerstreet.microservice_1.client.http.service.HttpService;

public class HttpClient {

    private HttpClient() {

    }

    public static Resources resources(HttpService httpService) {
        return new Resources(httpService);
    }


}

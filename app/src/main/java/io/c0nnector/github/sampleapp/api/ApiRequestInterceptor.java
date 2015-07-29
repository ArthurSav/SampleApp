package io.c0nnector.github.sampleapp.api;

import retrofit.RequestInterceptor;

/**
 * Intercepts api calls
 */
public class ApiRequestInterceptor implements RequestInterceptor {

    @Override
    public void intercept(RequestFacade request) {
        //do something
    }
}

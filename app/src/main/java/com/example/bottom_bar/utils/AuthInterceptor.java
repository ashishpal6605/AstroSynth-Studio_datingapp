package com.example.bottom_bar.utils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthInterceptor implements Interceptor {

    private SessionManager sessionManager;

    public AuthInterceptor(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder requestBuilder = chain.request().newBuilder();

        if (sessionManager.getToken() != null) {
            requestBuilder.addHeader("Authorization", sessionManager.getToken());
        }
        return chain.proceed(requestBuilder.build());
    }
}

package com.example.bottom_bar.network;

import com.example.bottom_bar.service.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitClient {
    private static final String base_url = "https://meetatparty.com/api/";//base url
    private static RetrofitClient instance;
    private Retrofit retrofit; //retrofit object

    private RetrofitClient() { //constructor
        retrofit = new Retrofit.Builder().baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create()).build();

    }

    public static synchronized RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }
        return instance;

    }

    public Api getApis() { //defining api function
        return retrofit.create(Api.class);
    }
}

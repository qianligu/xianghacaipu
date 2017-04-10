package com.jaxsen.xianghacaipu.ui.food.api;

import com.jaxsen.xianghacaipu.contract.HttpParams;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;



public class Api {

    private static Apiservice apiService;

    public static Apiservice getApiService(){
        if (apiService == null) {
            initApiService();
        }

        return apiService;
    }

    private static void initApiService() {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(HttpParams.HOST)
                .build();
        apiService = retrofit.create(Apiservice.class);
    }
}

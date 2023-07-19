package com.example.e_commerce.data.source.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyRetrofit {

    private static Retrofit retrofit = null;
    public static Apis getApis(){
        if (retrofit== null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl("https://student.valuxapps.com/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(Apis.class);
    }


}

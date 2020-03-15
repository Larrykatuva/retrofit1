package com.example.retrofit2;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String BASE_URL = "http://10.0.2.2:5000/";
    private  static RetrofitClient mInstance;
    private Retrofit retrofit;

    //retrofit client constructor
    private RetrofitClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    //getting the synchronised instance of the class
    public static  synchronized RetrofitClient getInstance(){
        if (mInstance == null){
            mInstance = new RetrofitClient();
        }
        return mInstance;
    }

    //method of getting the api
    public Api getApi(){
        return retrofit.create(Api.class);
    }
}

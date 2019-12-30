package com.example.ui.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {

    /*這裡為什麼要static*/
    private static RetrofitManager mInstance=new RetrofitManager();
    private LoginService loginService;

    private RetrofitManager(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://web.nutc-imac.com:6789/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        loginService=retrofit.create(LoginService.class);
    }

    public  static  RetrofitManager getInstance(){
        return mInstance;
    }
    public LoginService getLoginService(){
        return loginService;
    }
}

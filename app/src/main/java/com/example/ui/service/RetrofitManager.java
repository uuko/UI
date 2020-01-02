package com.example.ui.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {

    /*這裡為什麼要static*/
    private static RetrofitManager mInstance=new RetrofitManager();
    private LoginService loginService;
    Gson gson = new GsonBuilder()
            .setLenient()
            .create();
    private RetrofitManager(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://10.1.1.71:8000/api/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        loginService=retrofit.create(LoginService.class);
    }

    public  static  RetrofitManager getInstance(){
        return mInstance;
    }
    public LoginService getLoginService(){
        return loginService;
    }

    public LoginService getLoginImformation() {
        return loginService;
    }
    public LoginService getCustomName(){
        return loginService;
    }
    public LoginService getManufactureNumber(){
        return loginService;
    }
}

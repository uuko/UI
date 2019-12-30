package com.example.ui.service;

import com.example.ui.model.LoginModel;
import com.example.ui.model.LoginTokenModel;
import com.example.ui.model.LogoutModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface LoginService {

    @FormUrlEncoded
    @POST("auth/")
    Call<LoginTokenModel> getLoginToken(@Field("account") String account, @Field("password") String password);

    @GET("auth/{Token}")
    Call<LoginModel> getLoginImformation(@Path("Token") String Token);

    @GET("auth/logout/{Token}")
    Call<LogoutModel> getLogout(@Path("Token") String Token);

//    @GET("/auth/login")

}

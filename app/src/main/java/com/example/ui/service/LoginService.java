package com.example.ui.service;

import com.example.ui.model.CustomNameModel;
import com.example.ui.model.LoginModel;
import com.example.ui.model.LoginTokenModel;
import com.example.ui.model.LogoutModel;
import com.example.ui.model.ManufactureModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface LoginService {

    @FormUrlEncoded
    @POST("auth/login")
    Call<LoginTokenModel> getLoginToken(@Field("account") String account, @Field("password") String password);

//    @GET("auth/{Token}")
//    Call<LoginModel> getLoginImformation(@Path("Token") String Token);
    @GET("auth/")
    Call<LoginModel> getLoginImformation(@Query("token") String Token);
    @GET("auth/logout/{Token}")
    Call<LogoutModel> getLogout(@Query("token") String Token);

    @GET("app-search-customer")
    Call<CustomNameModel> getCustomName(@Query("customer_name") String custom_name ,@Query("token") String token);

    @GET("app-search-mo")
    Call<ManufactureModel> getManufactureId (@Query("mo_id") String mo_id , @Query("token") String token);


//    @GET("/auth/login")

}

package com.example.ui.datamodel;

import android.util.Log;

import com.example.ui.model.LoginModel;
import com.example.ui.service.LoginService;
import com.example.ui.service.RetrofitManager;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.ui.LoginActivity.preferencesHelperImp;


public class LoginTokenDataModel {
    private LoginService loginService=
            RetrofitManager.getInstance().getLoginImformation();

    public void getLoginAccount(String token, final OnDataReadyCallback callback){
        loginService.getLoginImformation(token)
                .enqueue(new Callback<LoginModel>() {
                    @Override
                    public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {

                        callback.onDataReady(response.body().getName());
                        preferencesHelperImp.setNameData(response.body().getName());
                        Log.d("456", "paccount: "+preferencesHelperImp.getNameData());
                        Log.d("123", "onaccount: "+response.body().getName());
                    }

                    @Override
                    public void onFailure(Call<LoginModel> call, Throwable t) {
                        Log.d("123", "onFailure: "+t);
                    }
                });
    }

    public  interface  OnDataReadyCallback{
        void onDataReady(String account);
    }
}

package com.example.ui.datamodel;

import android.util.Log;

import com.example.ui.model.LoginModel;
import com.example.ui.model.LoginTokenModel;
import com.example.ui.model.LogoutModel;
import com.example.ui.service.LoginService;
import com.example.ui.service.RetrofitManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.ui.LoginActivity.preferencesHelperImp;

public class LoginLogoutModel {
    private LoginService loginService=
            RetrofitManager.getInstance().getLoginImformation();


    public void getLogoutTokens(String token, final LoginLogoutModel.OnDataReadyCallback callback){
        loginService.getLogout(token)
                .enqueue(new Callback<LogoutModel>() {
                    @Override
                    public void onResponse(Call<LogoutModel> call, Response<LogoutModel> response) {
                        callback.onDataReady(response.body().getStatus());
                    }

                    @Override
                    public void onFailure(Call<LogoutModel> call, Throwable t) {

                    }
                });
    }

    public  interface  OnDataReadyCallback{
        void onDataReady(int status);
    }
}

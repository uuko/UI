package com.example.ui.datamodel;

import android.util.Log;
import android.widget.Toast;

import com.example.ui.Shareperference.PreferencesHelperImp;
import com.example.ui.model.LoginModel;
import com.example.ui.model.LoginTokenModel;
import com.example.ui.service.LoginService;
import com.example.ui.service.RetrofitManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.ui.LoginActivity.preferencesHelperImp;

public class LoginDataModel  {

    private LoginService loginService=
            RetrofitManager.getInstance().getLoginService();

    public void getLoginTokens(String account, String password, final OnDataReadyCallback callback){
        loginService.getLoginToken(account,password)
                .enqueue(new Callback<LoginTokenModel>() {
                    @Override
                    public void onResponse(Call<LoginTokenModel> call, Response<LoginTokenModel> response) {
                        callback.onDataReady(response.body().getToken());
                        preferencesHelperImp.setStringData(response.body().getToken());
                        Log.d("123", "onResponse: "+preferencesHelperImp.getStringData());
                    }

                    @Override
                    public void onFailure(Call<LoginTokenModel> call, Throwable t) {
                        Log.d("123", "onFailure: "+t);
                    }
                });
    }


    public  interface  OnDataReadyCallback{
        void onDataReady(String logindata);
    }
}

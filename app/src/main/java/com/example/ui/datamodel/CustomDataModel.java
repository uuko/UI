package com.example.ui.datamodel;

import android.util.Log;

import com.example.ui.model.CustomNameModel;
import com.example.ui.model.LoginTokenModel;
import com.example.ui.service.LoginService;
import com.example.ui.service.RetrofitManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.ui.LoginActivity.preferencesHelperImp;

public class CustomDataModel {
    private LoginService loginService= RetrofitManager.getInstance().getCustomName();

    public void  getCustomName(String custom_name,String token,final CustomDataModel.OnDataReadyCallback callback){
        Log.d("123", "getCustomName: "+custom_name+token);
        loginService.getCustomName(custom_name,token)
                .enqueue(new Callback<CustomNameModel>() {
                    @Override
                    public void onResponse(Call<CustomNameModel> call, Response<CustomNameModel> response) {
                        callback.onDataReady(response.body().getCustomer_name());
                        Log.d("123", "customname: "+response.body().getCustomer_name());
                    }

                    @Override
                    public void onFailure(Call<CustomNameModel> call, Throwable t) {
                        Log.d("123", "onFailure: "+t);
                    }
                });
    }

    public  interface  OnDataReadyCallback{
        void onDataReady(String custom_name);
    }
}

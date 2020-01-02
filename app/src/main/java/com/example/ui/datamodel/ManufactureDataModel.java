package com.example.ui.datamodel;

import android.util.Log;


import com.example.ui.model.ManufactureModel;
import com.example.ui.service.LoginService;
import com.example.ui.service.RetrofitManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.ui.LoginActivity.preferencesHelperImp;

public class ManufactureDataModel {
    private LoginService loginService= RetrofitManager.getInstance().getManufactureNumber();

    public void getManufactureIds(String mo_id, String token, final ManufactureDataModel.OnDataReadyCallback callback){
        loginService.getManufactureId(mo_id,token)
                .enqueue(new Callback<ManufactureModel>() {
                    @Override
                    public void onResponse(Call<ManufactureModel> call, Response<ManufactureModel> response) {
                        callback.onDataReady(response.body().getMo_id());
                        Log.d("123", "mo_id: "+response.body().getMo_id());
                    }

                    @Override
                    public void onFailure(Call<ManufactureModel> call, Throwable t) {
                        Log.d("123", "moonFailurer: "+t);
                    }

                });
    }

    public  interface  OnDataReadyCallback{
        void onDataReady(String mo_id);
    }
}

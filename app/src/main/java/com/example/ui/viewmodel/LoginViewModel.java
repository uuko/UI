package com.example.ui.viewmodel;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ui.datamodel.LoginDataModel;
import com.example.ui.model.LoginModel;

public class LoginViewModel extends ViewModel {

    private LoginDataModel loginDataModel;

    private final MutableLiveData<String> data = new MutableLiveData<>();
    LiveData<String> getData(){
        return data;
    }

    void getLoginTokens(String account,String password){
        loginDataModel.getLoginTokens(account, password, new LoginDataModel.OnDataReadyCallback() {
            @Override
            public void onDataReady(String logindata) {
                    data.setValue(logindata);
            }
        });
    }
}

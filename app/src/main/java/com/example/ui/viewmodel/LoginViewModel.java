package com.example.ui.viewmodel;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ui.MainActivity;
import com.example.ui.datamodel.LoginDataModel;
import com.example.ui.datamodel.LoginLogoutModel;
import com.example.ui.datamodel.LoginTokenDataModel;
import com.example.ui.model.LoginModel;

public class LoginViewModel extends ViewModel {

    private LoginDataModel loginDataModel;
    private LoginTokenDataModel loginTokenDataModel;
    private LoginLogoutModel loginLogoutModel;

    private final MutableLiveData<String> data = new MutableLiveData<>();
    LiveData<String> getData(){
        return data;
    }

   public void getLoginTokens(String account,String password){
        loginDataModel = new LoginDataModel();
        loginDataModel.getLoginTokens(account, password, new LoginDataModel.OnDataReadyCallback() {
            @Override
            public void onDataReady(String logindata) {
                Log.d("ok", "onDataReady: "+logindata);
                    data.setValue(logindata);
            }
        });
    }

    public void getLoginAccounts(String token){
        loginTokenDataModel=new LoginTokenDataModel();
        loginTokenDataModel.getLoginAccount(token, new LoginTokenDataModel.OnDataReadyCallback() {
            @Override
            public void onDataReady(String account) {
                Log.d("account", "onDataReady: "+account);
            }
        });
    }

    public void getLogoutstatus(String token){
        loginLogoutModel=new LoginLogoutModel();
        loginLogoutModel.getLogoutTokens(token, new LoginLogoutModel.OnDataReadyCallback() {
            @Override
            public void onDataReady(int status) {
                Log.d("123", "status: "+status);
            }
        });
    }
}

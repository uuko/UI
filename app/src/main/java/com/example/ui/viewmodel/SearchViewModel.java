package com.example.ui.viewmodel;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.example.ui.datamodel.CustomDataModel;
import com.example.ui.datamodel.ManufactureDataModel;
import com.example.ui.model.CustomNameModel;

public class SearchViewModel extends ViewModel {

    private CustomDataModel customDataModel;
    private ManufactureDataModel manufactureDataModel;

    public void  getCustomNames(String custom_name,String token){
        customDataModel=new CustomDataModel();
        customDataModel.getCustomName(custom_name, token, new CustomDataModel.OnDataReadyCallback() {
            @Override
            public void onDataReady(String custom_name) {
                Log.d("123", "status: "+custom_name);
            }
        });
    }

    public  void  getManufactureId(String mo_id,String token){
        manufactureDataModel=new ManufactureDataModel();
        manufactureDataModel.getManufactureIds(mo_id, token, new ManufactureDataModel.OnDataReadyCallback() {
            @Override
            public void onDataReady(String mo_id) {
                Log.d("123", "onDataReady: "+mo_id);
            }
        });
    }
}

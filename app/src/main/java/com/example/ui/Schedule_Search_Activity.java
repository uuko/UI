package com.example.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.ui.datamodel.CustomDataModel;
import com.example.ui.datamodel.ManufactureDataModel;

import java.util.ArrayList;
import java.util.List;

public class Schedule_Search_Activity extends AppCompatActivity {
    private Spinner made_spinner;
    private Button online_date,checked,manufacture;
    private EditText custom_name,mo_id;
    private   String custom_name_val,mo_id_val;
    private CustomDataModel customDataModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule__search_);
        made_spinner=findViewById(R.id.made_spinner);

        final String[] lunch = {"雷射"};
        ArrayAdapter<String> lunchList = new ArrayAdapter<>(Schedule_Search_Activity.this,
                android.R.layout.simple_spinner_dropdown_item,
                lunch);
        made_spinner.setAdapter(lunchList);


        online_date=findViewById(R.id.online_date);
        online_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                custom_name=findViewById(R.id.custom_name);
                custom_name_val=custom_name.getText().toString();

                OnlineDateFragment onlineDateFragment=new OnlineDateFragment();
                Bundle bundle = new Bundle();
                bundle.putString("edttext", custom_name_val);


                onlineDateFragment.setArguments(bundle);
                onlineDateFragment.show(getSupportFragmentManager(),"online_date");
            }
        });




        checked=findViewById(R.id.checked);
        checked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent report_work=new Intent(Schedule_Search_Activity.this,Report_Work_Activity.class);
                startActivity(report_work);
            }
        });


        manufacture=findViewById(R.id.manufacture);
        manufacture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mo_id=findViewById(R.id.mo_id);
                mo_id_val=mo_id.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("mo_id", mo_id_val);

                ManufactureFragment manufactureFragment=new ManufactureFragment();
                manufactureFragment.setArguments(bundle);
                manufactureFragment.show(getSupportFragmentManager(),"manufacture");
            }
        });
    }

    public String getCustom_name_val(){
        return custom_name_val;
    }
}

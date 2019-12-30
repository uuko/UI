package com.example.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class Schedule_Search_Activity extends AppCompatActivity {
    private Spinner made_spinner;
    private Button online_date;
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
                OnlineDateFragment onlineDateFragment=new OnlineDateFragment();
                onlineDateFragment.show(getSupportFragmentManager(),"online_date");
            }
        });



    }
}

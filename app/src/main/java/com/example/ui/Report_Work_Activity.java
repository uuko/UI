package com.example.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class Report_Work_Activity extends AppCompatActivity {

    private TabLayout report_tab_layout;
    private ViewPager report_tab_viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report__work_);

        report_tab_layout=findViewById(R.id.product_des_tablayout);
        report_tab_viewPager=findViewById(R.id.product_des_tabviewpager);

        report_tab_viewPager.setAdapter(new Report_Work_Adapter(getSupportFragmentManager(),report_tab_layout.getTabCount()));
       report_tab_viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(report_tab_layout));
        report_tab_layout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                report_tab_viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
   }
}

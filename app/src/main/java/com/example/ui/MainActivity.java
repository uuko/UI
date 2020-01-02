package com.example.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


import com.example.ui.Shareperference.PreferencesHelperImp;
import com.google.android.material.tabs.TabLayout;

import static com.example.ui.LoginActivity.preferencesHelperImp;

public class MainActivity extends AppCompatActivity {
    private TabLayout product_tab_layout;
    private ViewPager product_tab_viewPager;
    private TextView name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        product_tab_layout=findViewById(R.id.product_des_tablayout);
        product_tab_viewPager=findViewById(R.id.product_des_tabviewpager);
        name=findViewById(R.id.name);
        Log.d("456", "onCreateView: "+preferencesHelperImp.getNameData());
//
        name.setText(preferencesHelperImp.getNameData());

        product_tab_viewPager.setAdapter(new Product_Main_Adapter(getSupportFragmentManager(),product_tab_layout.getTabCount()));
        product_tab_viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(product_tab_layout));
        product_tab_layout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                product_tab_viewPager.setCurrentItem(tab.getPosition());
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

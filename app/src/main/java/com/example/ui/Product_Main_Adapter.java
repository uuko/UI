package com.example.ui;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class Product_Main_Adapter extends FragmentPagerAdapter {
    private int totalpages;
    @NonNull
    @Override

    /*
    Attempt to invoke virtual method 'java.lang.Class java.lang.Object.getClass()' on a null object reference
    at android.support.v4.app.BackStackRecord.doAddOp(BackStackRecord.java:380)
    沒有返回相應數量
     */
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                ProduceScheduleFragment produceScheduleFragment=new ProduceScheduleFragment();
                return produceScheduleFragment;
            case 1:
                ScheduleModifyFragment scheduleModifyFragment=new ScheduleModifyFragment();
                return scheduleModifyFragment;
            case 2:
                ProduceScheduleFragment produceScheduleFragment2=new ProduceScheduleFragment();
                return produceScheduleFragment2;
                default:
                    return null;

        }
//        ProduceScheduleFragment produceScheduleFragment=new ProduceScheduleFragment();
//           return produceScheduleFragment;

    }

        @Override
        public int getCount () {
            return totalpages;
        }

    public Product_Main_Adapter(@NonNull FragmentManager fm, int totalpages){
            super(fm);
            this.totalpages = totalpages;
        }

}

package com.example.ui;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class Report_Work_Adapter  extends FragmentPagerAdapter {

    private int total_pages;
    public Report_Work_Adapter(@NonNull FragmentManager fm,int total_pages) {
        super(fm);
        this.total_pages=total_pages;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                ProduceScheduleFragment produceScheduleFragment = new ProduceScheduleFragment();
                return produceScheduleFragment;
            case 1:
                ScheduleModifyFragment scheduleModifyFragment = new ScheduleModifyFragment();
                return scheduleModifyFragment;
            case 2:
                ProduceScheduleFragment produceScheduleFragment2 = new ProduceScheduleFragment();
                return produceScheduleFragment2;
            case 3:
                Aseemble_Instruction_Fragment aseemble_instruction_fragment = new Aseemble_Instruction_Fragment();
                return aseemble_instruction_fragment;
            case 4:
                SaleOrderFragment saleOrderFragment  = new SaleOrderFragment();
                return saleOrderFragment;

            default:
                return null;
         }
    }

    @Override
    public int getCount() {
        return total_pages;
    }
}

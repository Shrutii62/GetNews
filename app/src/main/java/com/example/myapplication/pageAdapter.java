package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class pageAdapter extends FragmentPagerAdapter {


int tabcount;


    public pageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcount= behavior;
    }



    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return  new Homefragment();

            case 1:
                return  new Sportsfregment();

            case 2:
                return  new Healthfragment();

            case 3:
                return  new Sciencefregment();

            case 4:
                return  new Entertainmentfragment();

            case 5:
                return  new Techfragment();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {

        return tabcount;
    }
}

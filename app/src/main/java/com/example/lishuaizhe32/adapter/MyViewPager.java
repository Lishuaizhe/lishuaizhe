package com.example.lishuaizhe32.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.lishuaizhe32.fragment.Fragmentone;
import com.example.lishuaizhe32.fragment.Fragmentthree;
import com.example.lishuaizhe32.fragment.Fragmenttow;

public class MyViewPager extends FragmentPagerAdapter {

    private String[] s = new String[]{"购物车","订单","空白","空白"};

    public MyViewPager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
               return   new Fragmentone();
            case 1:
                return  new Fragmenttow();
            default:
                return  new Fragmentthree();
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return s[position];
    }

    @Override
    public int getCount() {
        return s.length;
    }
}

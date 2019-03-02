package com.example.lishuaizhe32.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.lishuaizhe32.R;
import com.example.lishuaizhe32.adapter.MyViewPager;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewpaget;
    private TabLayout mTablayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        initView();
        initData();
    }

    private void initData() {
        MyViewPager viewPager = new MyViewPager(getSupportFragmentManager());
        mViewpaget.setAdapter(viewPager);
        mTablayout.setupWithViewPager(mViewpaget);
    }

    private void initView() {
        mViewpaget =  findViewById(R.id.viewpaget);
        mTablayout =  findViewById(R.id.tablayout);
    }
}

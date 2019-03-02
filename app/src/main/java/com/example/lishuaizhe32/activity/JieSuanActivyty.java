package com.example.lishuaizhe32.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lishuaizhe32.R;
import com.example.lishuaizhe32.adapter.OneAdapter;
import com.example.lishuaizhe32.adapter.OneAdapter2;
import com.example.lishuaizhe32.entiey.OneBean;
import com.example.lishuaizhe32.fragment.Fragmenttow;
import com.example.lishuaizhe32.mvp.one1.oneContract;
import com.example.lishuaizhe32.mvp.one1.onePresenter;
import com.google.gson.Gson;

import java.util.HashMap;

public class JieSuanActivyty extends AppCompatActivity implements View.OnClickListener,oneContract.I_View {

    private RecyclerView mRecycler;
    private TextView mJiage;
    /**
     * 提交订单
     */
    private Button mJiesuan;
    private int a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jie_suan_activyty);
        getSupportActionBar().hide();
        initView();
        onePresenter presenter = new onePresenter(this);
        presenter.GetData(new HashMap<String, String>());
        mJiesuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(JieSuanActivyty.this,"提交订单成功",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(JieSuanActivyty.this,Fragmenttow.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        mRecycler =  findViewById(R.id.recycler);
        mJiage =  findViewById(R.id.jiage);
        mJiesuan =  findViewById(R.id.jiesuan);
        mJiesuan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.jiesuan:
                break;
        }
    }

    @Override
    public void Success(String s) {
        OneBean oneBean = new Gson().fromJson(s, OneBean.class);
        OneAdapter2 oneAdapter = new OneAdapter2(this, oneBean.result);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        mRecycler.setAdapter(oneAdapter);
        for (OneBean.ResultBean resultBean : oneBean.result) {
            a = resultBean.price*resultBean.count;
        }
        mJiage.setText(a+"");
    }

    @Override
    public void fuait(String msg) {

    }
}

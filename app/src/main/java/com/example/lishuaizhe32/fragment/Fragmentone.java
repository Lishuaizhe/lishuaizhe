package com.example.lishuaizhe32.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.lishuaizhe32.R;
import com.example.lishuaizhe32.activity.JieSuanActivyty;
import com.example.lishuaizhe32.adapter.OneAdapter;
import com.example.lishuaizhe32.entiey.OneBean;
import com.example.lishuaizhe32.mvp.one1.oneContract;
import com.example.lishuaizhe32.mvp.one1.onePresenter;
import com.google.gson.Gson;

import java.util.HashMap;

public class Fragmentone extends Fragment implements View.OnClickListener,oneContract.I_View {

    private View view;
    private RecyclerView mRecycler;
    /**
     * 全选
     */
    private CheckBox mQuanxuan;
    private TextView mJiage;
    /**
     * 去结算
     */
    private Button mJiesuan;
    private OneBean oneBean;
    private OneAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.from(getContext()).inflate(R.layout.one, container, false);
        initView(view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initData();


    }

    private void initData() {
        onePresenter presenter = new onePresenter(this);
        presenter.GetData(new HashMap<String, String>());
    }

    private void initView(View view) {
        mRecycler =  view.findViewById(R.id.recycler);
        mQuanxuan =  view.findViewById(R.id.quanxuan);
        mJiage =  view.findViewById(R.id.jiage);
        mJiesuan =  view.findViewById(R.id.jiesuan);
        mJiesuan.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.jiesuan:
                jiesuan();
                break;
        }
    }

    /*
    * 点击结算订单
    * */
    private void jiesuan() {
        //http://172.17.8.100/small/order/verify/v1/createOrder
        Intent intent = new Intent(getActivity(),JieSuanActivyty.class);
        startActivity(intent);
    }

    @Override
    public void Success(String s) {
        oneBean = new Gson().fromJson(s, OneBean.class);
        adapter = new OneAdapter(getActivity(), oneBean.result);
        mRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecycler.setAdapter(adapter);

        /*
         * 点击全选
         * */
        mQuanxuan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            private int jiage;

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    for (OneBean.ResultBean resultBean : oneBean.result) {
                        resultBean.isChecked=true;
                        jiage = +resultBean.price*resultBean.count;
                    }
                    mJiage.setText(jiage+"");
                    mRecycler.setAdapter(adapter);
                }else {
                    for (OneBean.ResultBean resultBean : oneBean.result) {
                        resultBean.isChecked=false;
                    }
                    mJiage.setText("0");
                    mRecycler.setAdapter(adapter);
                }
            }
        });
    }

    @Override
    public void fuait(String msg) {



    }
}

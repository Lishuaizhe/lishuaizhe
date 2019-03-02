package com.example.lishuaizhe32.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.lishuaizhe32.R;
import com.example.lishuaizhe32.entiey.OneBean;
import com.example.lishuaizhe32.mvp.one2.one2Contract;
import com.example.lishuaizhe32.mvp.one2.one2Presenter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;

import java.util.HashMap;

public class XiangQingActivity extends AppCompatActivity implements one2Contract.I_View {

    private SimpleDraweeView mImage;
    private TextView mName;
    private TextView mPrice;
    private WebView mWebwiew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiang_qing);
        initView();
        getSupportActionBar().hide();

        Intent intent = this.getIntent();
        String zzz = intent.getStringExtra("zzz");

        one2Presenter presenter = new one2Presenter(this);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("commodityId", zzz);
        presenter.GetData(hashMap);

        //http://172.17.8.100/small/commodity/v1/CommodityCommentList

    }

    @Override
    public void Success(String s) {
        OneBean2 oneBean2 = new Gson().fromJson(s, OneBean2.class);
        OneBean2.ResultBean result = oneBean2.getResult();
        String[] split = result.getPicture().split(",");
        mImage.setImageURI(split[0]);
        mName.setText(result.getCategoryName());
        mPrice.setText(result.getPrice()+"");
        WebSettings settings = mWebwiew.getSettings();
        settings.setJavaScriptEnabled(true);//支持JS
        mWebwiew.loadDataWithBaseURL(null, result.getDetails(), "text/html", "utf-8", null);
    }

    @Override
    public void fuait(String msg) {

    }

    private void initView() {
        mImage =  findViewById(R.id.image);
        mName =  findViewById(R.id.name);
        mPrice =  findViewById(R.id.price);
        mWebwiew =  findViewById(R.id.webwiew);
        mWebwiew.getSettings().setSupportZoom(true);
        mWebwiew.getSettings().setBuiltInZoomControls(true);
        mWebwiew.getSettings().setUseWideViewPort(true);
    }
}

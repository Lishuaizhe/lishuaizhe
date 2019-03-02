package com.example.lishuaizhe32.mvp.one2;

import com.example.lishuaizhe32.net.OkhttpCallback;
import com.example.lishuaizhe32.net.OkhttpUtils;
import com.example.lishuaizhe32.user.UrlBean;

import java.util.HashMap;

public class one2Model implements one2Contract.I_Model{


    @Override
    public void GetData(HashMap<String, String> hashMap, final CallBack callBack) {
        OkhttpUtils.getOkhttpUtils().GetData(UrlBean.Xiangq, hashMap, new OkhttpCallback() {
            @Override
            public void Success(String result) {
                callBack.Success(result);
            }

            @Override
            public void Fuila(String msg) {
                callBack.Fuile(msg);
            }
        });
    }

    public interface CallBack {
        void Success(String S);
        void Fuile(String s);
    }
}

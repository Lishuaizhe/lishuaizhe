package com.example.lishuaizhe32.mvp.one2;

import java.util.HashMap;

public class one2Presenter extends one2Contract.I_Persenter{

    private one2Model model;
    private one2Contract.I_View view;

    public one2Presenter(one2Contract.I_View view) {
        this.view = view;
        model = new one2Model();
    }

    @Override
    public void GetData(HashMap<String, String> hashMap) {
        model.GetData(hashMap, new one2Model.CallBack() {
            @Override
            public void Success(String S) {
                view.Success(S);
            }

            @Override
            public void Fuile(String s) {
                view.fuait(s);
            }
        });
    }
}

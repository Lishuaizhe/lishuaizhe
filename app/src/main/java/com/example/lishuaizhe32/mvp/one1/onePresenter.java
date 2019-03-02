package com.example.lishuaizhe32.mvp.one1;

import java.util.HashMap;

public class onePresenter extends oneContract.I_Persenter{

    private oneModel model;
    private oneContract.I_View view;

    public onePresenter(oneContract.I_View view) {
        this.view = view;
        model = new oneModel();
    }

    @Override
    public void GetData(HashMap<String, String> hashMap) {
        model.GetData(hashMap, new oneModel.CallBack() {
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

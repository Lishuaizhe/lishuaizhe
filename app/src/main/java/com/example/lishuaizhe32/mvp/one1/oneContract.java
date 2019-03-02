package com.example.lishuaizhe32.mvp.one1;

import java.util.HashMap;

public interface oneContract {

    abstract class I_Persenter{
        abstract void GetData(HashMap<String,String> hashMap);
    }

    interface I_Model{
        void GetData(HashMap<String,String> hashMap,oneModel.CallBack callBack);
    }

    interface I_View{
        void Success(String s);
        void fuait(String msg);
    }



}

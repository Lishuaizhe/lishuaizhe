package com.example.lishuaizhe32.mvp.one2;

import java.util.HashMap;

public interface one2Contract {

    abstract class I_Persenter{
        abstract void GetData(HashMap<String,String> hashMap);
    }

    interface I_Model{
        void GetData(HashMap<String, String> hashMap, one2Model.CallBack callBack);
    }

    interface I_View{
        void Success(String s);
        void fuait(String msg);
    }



}

package com.example.lishuaizhe32.entiey;

import java.util.List;

public class OneBean {


    public String message;
    public String status;
    public List<ResultBean> result;

    public static class ResultBean {

        public int commodityId;
        public String commodityName;
        public int count;
        public String pic;
        public int price;
        public boolean isChecked;//一级列表是否选中标志位
        public int pos;
        public int productNum =1;

    }
}

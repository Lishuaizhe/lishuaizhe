package com.example.lishuaizhe32.net;

import android.os.Handler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkhttpUtils {

    private Handler handler  = new Handler() ;

    private static OkHttpClient okHttpClient;

    private static OkhttpUtils okhttpUtils;

    public OkhttpUtils() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .writeTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .build();
    }

    public static OkhttpUtils getOkhttpUtils(){
        if (okHttpClient==null){
            okhttpUtils = new OkhttpUtils();
        }
        return okhttpUtils;
    }


    public void GetData(String url, HashMap<String,String> parmas, final OkhttpCallback okhttpCallback){

        StringBuilder p = new StringBuilder();

        if (parmas!=null&&parmas.size()>0){
            for (Map.Entry<String, String> map : parmas.entrySet()) {
                p.append(map.getKey()).append("=").append(map.getValue()).append("&");
            }
        }

        Request request = new Request.Builder().url(url+"?"+p.toString())//1550992070631607
                .addHeader("userId","1072").addHeader("sessionId","15510870502561072")
                .get()
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(final Call call, IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        okhttpCallback.Fuila("网络异常");
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String body = response.body().string();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        okhttpCallback.Success(body);
                    }
                });
            }
        });
    }

}

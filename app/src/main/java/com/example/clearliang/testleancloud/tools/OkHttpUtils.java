package com.example.clearliang.testleancloud.tools;

import com.bumptech.glide.Glide;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

/**
 * Created by ClearLiang on 2018/1/4.
 *
 * Okhttp的管理类，封装okhttp的操作
 */

public class OkHttpUtils {

    public static void initClient(){
        OkHttpClient mOkHttpClient = new OkHttpClient();

    }
    //创建okHttpClient对象

    final Request mRequest = new Request.Builder()
            .url("").build();
}

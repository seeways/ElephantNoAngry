package com.jiataoyuan.elephantnoangry.application;

import android.app.Application;

import com.zhy.http.okhttp.OkHttpUtils;

import org.litepal.LitePal;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        LitePal.initialize(this);// 初始化数据库类库
        OkHttpUtils.initClient( // 初始化okHttp类库
                new OkHttpClient.Builder()
                        .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                        .readTimeout(10000L, TimeUnit.MILLISECONDS)
                        .build());

    }
}

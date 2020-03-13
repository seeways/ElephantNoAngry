package com.jiataoyuan.elephantnoangry.lifecycle;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

import com.jiataoyuan.elephantnoangry.activity.LoginActivity;
import com.jiataoyuan.elephantnoangry.bean.LoginInfo;

import org.litepal.LitePal;

public class MyObserver implements DefaultLifecycleObserver {
    private static final String TAG = "MyListener";

    private Activity activity;

    public MyObserver(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onCreate(@NonNull LifecycleOwner owner) {
        Log.d(TAG, "onCreate()");
        checkLogin();
    }

    @Override
    public void onStart(@NonNull LifecycleOwner owner) {
        Log.d(TAG, "onStart()");
    }

    @Override
    public void onResume(@NonNull LifecycleOwner owner) {
        Log.d(TAG, "onResume()");
    }

    @Override
    public void onPause(@NonNull LifecycleOwner owner) {
        Log.d(TAG, "onPause()");
    }

    @Override
    public void onStop(@NonNull LifecycleOwner owner) {
        Log.d(TAG, "onStop()");
    }

    @Override
    public void onDestroy(@NonNull LifecycleOwner owner) {
        Log.d(TAG, "onDestroy() ");

    }

    private void checkLogin() {
        if (activity.getLocalClassName().equals("LoginActivity")) return;
        // 检索信息，如果已经存在对应的手机号，则替换
        LoginInfo loginInfo = LitePal.findFirst(LoginInfo.class);
        if (null == loginInfo) {
            Intent intent = new Intent(activity, LoginActivity.class);
            activity.startActivity(intent);
            activity.finish();
        }
    }


}
package com.jiataoyuan.elephantnoangry;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.jiataoyuan.elephantnoangry.activity.LoginActivity;
import com.jiataoyuan.elephantnoangry.activity.PermissionUtils;
import com.jiataoyuan.elephantnoangry.lifecycle.MyObserver;

public class MainActivity extends PermissionUtils {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLifecycle().addObserver(new MyObserver(this));
        setContentView(R.layout.activity_main);

        init();
    }

    @Override
    protected void onStart() {
        super.onStart();
        checkAndRequestPermissions();
    }

    private void init() {


    }



    public void mainClick(View view) {
        switch (view.getId()) {
            case R.id.main_btn: {
                Intent intent = new Intent(this, LoginActivity.class);
                intent.putExtra("test", "test");
                startActivity(intent);
                this.finish();
                break;
            }
            default:
                break;
        }

    }
}

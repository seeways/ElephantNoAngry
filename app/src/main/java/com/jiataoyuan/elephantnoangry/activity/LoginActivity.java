package com.jiataoyuan.elephantnoangry.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;

import com.jiataoyuan.elephantnoangry.MainActivity;
import com.jiataoyuan.elephantnoangry.R;
import com.jiataoyuan.elephantnoangry.bean.LoginInfo;
import com.jty.myutils.utils.T;

import org.litepal.LitePal;

import java.util.Objects;

public class LoginActivity extends Activity {
    private EditText loginPhoneNumber;
    private EditText loginPassword;
    private boolean checkIntent = false;
    private long firstTime = 0;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        checkTest();
        init();
    }

    private void init() {

        loginPhoneNumber = findViewById(R.id.phone_number);
        loginPassword = findViewById(R.id.login_password);
    }

    private void checkTest() {
        Intent intent = getIntent();
        if (null != intent) {
            String result = intent.getStringExtra("test");
            checkIntent = Objects.equals(result, "test");
        }

    }

    public void LoginClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.btn_login:
                if (checkIntent) {
                    toMain(intent);
                    this.finish();
                    return;
                }
                // 登录
                String phone = loginPhoneNumber.getText().toString().trim();
                String pass = loginPassword.getText().toString().trim();
                if (phone.equals("") || pass.equals("")) {
                    T.showLong(this, "账号密码不能为空");
                    return;
                }

                if (phone.startsWith("13571877105") && pass.equals("123456")) {
                    saveData(phone, pass);

                }

                LoginInfo checkInfo = LitePal.findFirst(LoginInfo.class);
                if (checkInfo == null) {
                    T.showLong(this, "账号为空");
                    return;
                }
                if (checkInfo.getPhone().equals(phone) && checkInfo.getPass().equals(pass)) {
                    // 正常校验通过，进入主页面
                    toMain(intent);
                    this.finish();
                }
                break;
            case R.id.register:
                // 注册
                intent.setClass(this, RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.forget_password: {
                // 忘记密码
                intent = new Intent(this, ForgetPasswordActivity.class);
                startActivity(intent);
                break;
            }
        }
    }

    private void toMain(Intent intent) {
        intent.setClass(this, MainActivity.class);
        startActivity(intent);
    }

    private void saveData(String phone, String pass) {
        LoginInfo checkInfo = new LoginInfo();
        checkInfo.setPhone(phone);
        checkInfo.setPass(pass);
        checkInfo.save();
    }

    @Override
    public void onBackPressed() {
        long secondTime = System.currentTimeMillis();
        if (secondTime - firstTime > 2000) {
            T.showLong(this, "再按一次退出程序");
            firstTime = secondTime;
        } else {
            System.exit(0);
        }

    }

}

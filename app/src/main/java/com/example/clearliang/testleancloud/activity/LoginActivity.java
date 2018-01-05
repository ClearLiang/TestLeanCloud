package com.example.clearliang.testleancloud.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.clearliang.testleancloud.tools.DialogUtils;
import com.example.clearliang.testleancloud.tools.EventBusUtils;
import com.example.clearliang.testleancloud.entity.MyEvent;
import com.example.clearliang.testleancloud.R;
import com.example.clearliang.testleancloud.base.BaseActivity;
import com.example.clearliang.testleancloud.interfaceview.LoginViewInterface;
import com.example.clearliang.testleancloud.presenter.LoginPresenter;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import javax.security.auth.callback.Callback;

import okhttp3.Call;

/**
 * Created by ClearLiang on 2018/1/4.
 *
 *登陆界面
 */

public class LoginActivity extends BaseActivity<LoginViewInterface,LoginPresenter> implements LoginViewInterface,View.OnClickListener{
    private Button mBtnLoginLogin;
    private TextView mTvLoginRegister,mTvLoginForger;
    private EditText mEtLoginUsername,mEtLoginPassword;

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

        EventBusUtils.sendEvent(new MyEvent(EventBusUtils.EventCode.MAIN_FRAGMENT,"向main发送信息"));
    }

    private void initView() {
        mEtLoginUsername = findViewById(R.id.et_login_username);
        mEtLoginPassword = findViewById(R.id.et_login_password);
        mTvLoginForger = findViewById(R.id.tv_login_forget);
        mTvLoginRegister = findViewById(R.id.tv_login_register);
        mBtnLoginLogin = findViewById(R.id.btn_login_login);
        mBtnLoginLogin.setOnClickListener(this);
        mTvLoginRegister.setOnClickListener(this);
        mTvLoginForger.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login_login:
                if(mPresenter.login(mEtLoginUsername.getText().toString(),mEtLoginPassword.getText().toString())){
                    Intent intent = new Intent(this,MainActivity.class);
                    startActivity(intent);
                }else {

                }
                break;
            case R.id.tv_login_forget:

                break;
            case R.id.tv_login_register:
                break;
        }
    }
}

package com.example.clearliang.testleancloud.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.clearliang.testleancloud.tools.EventBusUtils;
import com.example.clearliang.testleancloud.entity.MyEvent;
import com.example.clearliang.testleancloud.R;
import com.example.clearliang.testleancloud.base.BaseActivity;
import com.example.clearliang.testleancloud.interfaceview.LoginViewInterface;
import com.example.clearliang.testleancloud.presenter.LoginPresenter;

/**
 * Created by ClearLiang on 2018/1/4.
 *
 *登陆界面
 */

public class LoginActivity extends BaseActivity<LoginViewInterface,LoginPresenter> implements LoginViewInterface{

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EventBusUtils.sendEvent(new MyEvent(EventBusUtils.EventCode.MAIN_FRAGMENT,"向main发送信息"));
    }

}

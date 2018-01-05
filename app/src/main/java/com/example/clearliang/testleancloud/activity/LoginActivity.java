package com.example.clearliang.testleancloud.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.TextView;

import com.example.clearliang.testleancloud.tools.EventBusUtils;
import com.example.clearliang.testleancloud.entity.MyEvent;
import com.example.clearliang.testleancloud.R;
import com.example.clearliang.testleancloud.base.BaseActivity;
import com.example.clearliang.testleancloud.interfaceview.LoginViewInterface;
import com.example.clearliang.testleancloud.presenter.LoginPresenter;
import com.sunfusheng.glideimageview.GlideImageView;
import com.sunfusheng.glideimageview.progress.GlideApp;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by ClearLiang on 2018/1/4.
 *
 *登陆界面
 */

public class LoginActivity extends BaseActivity<LoginViewInterface,LoginPresenter> implements LoginViewInterface{
    private Button mBtnLoginLogin;
    private TextView mTvLoginRegister,mTvLoginForger;

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

    public void login(){
        String url = "";
        OkHttpUtils
                .get()
                .url(url)
                .addParams("username","")
                .addParams("password","")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {

                    }
                });
    }
}

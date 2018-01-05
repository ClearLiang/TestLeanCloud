package com.example.clearliang.testleancloud.presenter;

import android.util.Log;

import com.example.clearliang.testleancloud.base.BasePresenter;
import com.example.clearliang.testleancloud.interfaceview.LoginViewInterface;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by ClearLiang on 2018/1/4.
 */

public class LoginPresenter extends BasePresenter<LoginViewInterface> {
    LoginViewInterface mLoginViewInterface;

    public LoginPresenter(LoginViewInterface loginViewInterface) {
        mLoginViewInterface = loginViewInterface;
    }

    public boolean login(String username,String password){
        String url = "";
        final boolean[] isSuccessed = {false};
        OkHttpUtils
                .get()
                .url(url)
                .addParams("username",username)
                .addParams("password",password)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.i(TAG,"登录失败");
                        isSuccessed[0] = false;
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.i(TAG,"登陆成功");
                        isSuccessed[0] = true;
                    }
                });
        return isSuccessed[0];
    }
}

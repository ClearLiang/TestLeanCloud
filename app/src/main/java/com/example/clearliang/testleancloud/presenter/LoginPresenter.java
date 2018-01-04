package com.example.clearliang.testleancloud.presenter;

import com.example.clearliang.testleancloud.base.BasePresenter;
import com.example.clearliang.testleancloud.interfaceview.LoginViewInterface;

/**
 * Created by ClearLiang on 2018/1/4.
 */

public class LoginPresenter extends BasePresenter<LoginViewInterface> {
    LoginViewInterface mLoginViewInterface;

    public LoginPresenter(LoginViewInterface loginViewInterface) {
        mLoginViewInterface = loginViewInterface;
    }
}

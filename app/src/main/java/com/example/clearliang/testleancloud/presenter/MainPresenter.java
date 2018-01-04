package com.example.clearliang.testleancloud.presenter;

import com.example.clearliang.testleancloud.base.BasePresenter;
import com.example.clearliang.testleancloud.interfaceview.MainViewInterface;

/**
 * Created by ClearLiang on 2018/1/4.
 */

public class MainPresenter extends BasePresenter<MainViewInterface> {
    MainViewInterface mMainViewInterface;

    public MainPresenter(MainViewInterface mainViewInterface) {
        mMainViewInterface = mainViewInterface;
    }
}

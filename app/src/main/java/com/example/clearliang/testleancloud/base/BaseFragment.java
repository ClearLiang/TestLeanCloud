package com.example.clearliang.testleancloud.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.example.clearliang.testleancloud.tools.EventBusUtils;

/**
 * Created by ClearLiang on 2018/1/4.
 *
 * Fragment的基类
 */

public abstract class BaseFragment<V,T extends BasePresenter<V>> extends Fragment implements GlobalVariable {
    private T mPresenter;
    protected abstract T createPresenter();

    private Activity mActivity;

    protected void isRegisterEventBus(){

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.attachView((V) getActivity());
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBusUtils.unregister(this);
    }

}

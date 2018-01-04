package com.example.clearliang.testleancloud.base;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by ClearLiang on 2018/1/4.
 *
 */

public class BasePresenter<T> {

    Reference<T> mViewReference;

    private CompositeSubscription mCompositeSubscription;

    public void attachView(T view){
        mViewReference = new WeakReference<T>(view);
    }

    public void datachView(){
        if(mViewReference != null){
            mViewReference.clear();
            mViewReference = null;
        }
        onUnsubscribe();
    }

    protected T getView(){
        return mViewReference.get();
    }

    //RXjava取消注册，以避免内存泄露
    private void onUnsubscribe() {
        if(mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()){
            mCompositeSubscription.unsubscribe();
        }
    }

}

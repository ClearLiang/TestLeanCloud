package com.example.clearliang.testleancloud.entity;

/**
 * Created by ClearLiang on 2018/1/4.
 */

public class MyEvent {
    private int mTag;
    private String mMsg;

    public MyEvent(int tag, String msg) {
        mTag = tag;
        mMsg = msg;
    }

    public int getTag() {
        return mTag;
    }

    public void setTag(int tag) {
        mTag = tag;
    }

    public String getMsg() {
        return mMsg;
    }

    public void setMsg(String msg) {
        mMsg = msg;
    }
}

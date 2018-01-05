package com.example.clearliang.testleancloud.tools;

import com.example.clearliang.testleancloud.entity.MyEvent;
import com.zhy.http.okhttp.OkHttpUtils;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by ClearLiang on 2018/1/4.
 *
 * EventBus的工具类
 */

public class EventBusUtils {

    public static void register(Object subscriber){
        EventBus.getDefault().register(subscriber);
    }

    public static void unregister(Object subscriber){
        EventBus.getDefault().unregister(subscriber);
    }

    public static void sendEvent(MyEvent event){
        EventBus.getDefault().post(event);
    }

    public static void sendStickyEvent(MyEvent event){
        EventBus.getDefault().postSticky(event);
    }

    public class EventCode{
        public static final int MAIN_FRAGMENT = 0x000001;
        public static final int HOME_FRAGMENT = 0x000002;
        public static final int MEUN_FRAGMENT = 0x000003;

    }
}

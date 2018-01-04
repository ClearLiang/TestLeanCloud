package com.example.clearliang.testleancloud.base;

import android.app.Activity;

import java.util.Stack;

/**
 * Created by ClearLiang on 2018/1/4.
 *
 * App管理类，管理所有的Activity
 */

public class AppManager implements GlobalVariable {
    public static Stack<Activity> sActivityStack;
    public static AppManager sAppManager;

    private AppManager() {
    }

    /**
     * 获取AppManager的单例
     * */
    public static AppManager getAppManager() {
        if(sAppManager == null){
            synchronized (AppManager.class){
                sAppManager = new AppManager();
            }
        }
        return sAppManager;
    }
    /**
     * 添加Activity到堆栈
     * */
    public void addActivity(Activity activity){
        if(sActivityStack == null){
            sActivityStack = new Stack<>();
        }
        sActivityStack.add(activity);
    }
    /**
     * 获取当前Activity
     * */
    public Activity getCurrentActivity(){
        Activity activity = sActivityStack.lastElement();
        return activity;
    }
    /**
     * 结束指定Activity
     * */
    public void finishActivity(Activity activity){
        if(activity != null){
            sActivityStack.remove(activity);
            activity.finish();
            activity = null;
        }

    }
    /**
     * 结束当前Activity
     * */
    public void finishCurrentActivity(){
        Activity activity = sActivityStack.lastElement();
        finishActivity(activity);
    }
    /**
     * 结束指定类名的Activity
     * */
    public void finishActivity(Class<Activity> activityClass){
        for(Activity activity:sActivityStack){
            if(activity.getClass().equals(activityClass)){
                finishActivity(activity);
            }
        }
    }
    /**
     * 结束所有Activity
     * */
    public void finishAllActivity(){
        for(Activity activity:sActivityStack){
            finishActivity(activity);
        }
    }



}

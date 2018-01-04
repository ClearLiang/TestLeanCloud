package com.example.clearliang.testleancloud.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.clearliang.testleancloud.entity.MyEvent;
import com.example.clearliang.testleancloud.R;
import com.example.clearliang.testleancloud.base.BaseActivity;
import com.example.clearliang.testleancloud.interfaceview.MainViewInterface;
import com.example.clearliang.testleancloud.presenter.MainPresenter;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends BaseActivity<MainViewInterface,MainPresenter> implements MainViewInterface {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_message:
                    mTextMessage.setText(R.string.title_message);
                    return true;
                case R.id.navigation_linkman:
                    mTextMessage.setText(R.string.title_linkman);
                    return true;
                case R.id.navigation_dynamic:
                    mTextMessage.setText(R.string.title_dynamic);
                    return true;
            }
            return false;
        }
    };


    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = findViewById(R.id.message);
        BottomNavigationView navigation = findViewById(R.id.navigation);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    @Subscribe(threadMode = ThreadMode.MAIN,priority = 100)//在ui线程执行 优先级100
    public void onMessageEvent(MyEvent event){

    }



}

package com.example.clearliang.testleancloud.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.clearliang.testleancloud.R;
import com.example.clearliang.testleancloud.tools.DialogUtils;
import com.example.clearliang.testleancloud.tools.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ClearLiang on 2018/1/5.
 */

public class test extends AppCompatActivity {
    private Banner mBanner;
    private List<String> mImageList = new ArrayList();
    private Button mButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        initBanner();
        initBtn();

    }

    private void initBtn() {

        mButton = findViewById(R.id.btn);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogUtils.showNormalDialog(test.this, "大雨", 2,"确认","取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(test.this,"确认按钮",Toast.LENGTH_LONG).show();
                        dialog.dismiss();
                    }
                }, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(test.this,"取消按钮",Toast.LENGTH_LONG).show();
                        dialog.dismiss();
                    }
                });
            }
        });
    }

    private void initBanner() {
        mBanner = findViewById(R.id.banner);
        mBanner.setImageLoader(new GlideImageLoader());
        initDate();
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        mBanner.setImages(mImageList);
        mBanner.setBannerAnimation(Transformer.DepthPage);
        mBanner.isAutoPlay(true);
        mBanner.setDelayTime(2000);
        mBanner.start();
    }

    private void initDate() {
        mImageList.add("http://pic4.nipic.com/20091217/3885730_124701000519_2.jpg");
        mImageList.add("http://img.taopic.com/uploads/allimg/120727/201995-120HG1030762.jpg");
        mImageList.add("http://img.taopic.com/uploads/allimg/140116/267869-1401160T23259.jpg");
        mImageList.add("http://pic36.nipic.com/20131202/1272022_170853031381_2.jpg");
    }

    @Override
    protected void onStart() {
        super.onStart();
        mBanner.startAutoPlay();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mBanner.stopAutoPlay();
    }
}

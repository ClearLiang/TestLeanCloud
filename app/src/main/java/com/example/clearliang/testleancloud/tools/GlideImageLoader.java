package com.example.clearliang.testleancloud.tools;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by ClearLiang on 2018/1/5.
 */

public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Glide
                .with(context)
                .load(path)
                .centerCrop()
                .crossFade()
                .into(imageView);
    }
}

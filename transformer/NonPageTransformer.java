package com.example.myapplication.transformer;

import android.view.View;

import androidx.viewpager.widget.ViewPager;

/**
 * Created by zhy on 16/5/7.
 */
public class NonPageTransformer implements ViewPager.PageTransformer
{
    @Override
    public void transformPage(View page, float position)
    {

        page.setScaleX(0.999f);//hack

    }

    /**
     * 把自己默认的 给自己的实例  防止空指针错误
     */
    public static final ViewPager.PageTransformer INSTANCE = new NonPageTransformer();
}

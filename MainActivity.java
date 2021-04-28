package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.cardtransformer.AlphaAndScalePageTransformer;
import com.example.myapplication.transformer2.CubeOutTransformer;
import com.example.myapplication.transformer2.ZoomInTransformer;
import com.example.myapplication.transformer2.ZoomOutSlideTransformer;

/**
 * 一个逆扇形的  动画过度效果
 */
public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private PagerAdapter mAdapter;
    int[] imgRes = {R.drawable.a, R.drawable.b, R.drawable.d
        ,R.drawable.e,R.drawable.f,R.drawable.h,R.drawable.i,R.drawable.a,R.drawable.c};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
        //设置Page间间距
        mViewPager.setPageMargin(20);
        //设置缓存的页面数量
        mViewPager.setOffscreenPageLimit(3);

        mViewPager.setAdapter(mAdapter = new PagerAdapter() {
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ImageView view = new ImageView(MainActivity.this);
                view.setImageResource(imgRes[position]);
                container.addView(view);
                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }

            @Override
            public int getCount() {
                return imgRes.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object o) {
                return view == o;
            }
        });


   mViewPager.setPageTransformer(true,new CubeOutTransformer());
    }

}

package com.example.myapplication.transformer;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;

import androidx.viewpager.widget.ViewPager;


/**
 * 改变每张图片透明度的类
 */
public class AlphaPageTransformer extends BasePageTransformer
{
    private static final float DEFAULT_MIN_ALPHA = 0.5f;
    private float mMinAlpha = DEFAULT_MIN_ALPHA;

    public AlphaPageTransformer()
    {

    }

    public AlphaPageTransformer(float minAlpha)
    {

        this(minAlpha, NonPageTransformer.INSTANCE);

    }

    public AlphaPageTransformer(ViewPager.PageTransformer pageTransformer)
    {
        this(DEFAULT_MIN_ALPHA, pageTransformer);
    }

    public AlphaPageTransformer(float minAlpha, ViewPager.PageTransformer pageTransformer)
    {
        mMinAlpha = minAlpha;
        mPageTransformer = pageTransformer;
    }





    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void pageTransform(View view, float position)
    {
        view.setScaleX( 0.999f);//hack


        /**
         * 先把屏幕 两边的全部分出去
         */
        if (position < -1)
        { // [-Infinity,-1)
            view.setAlpha(mMinAlpha);
        } else if (position <= 1)
        { // [-1,1]

            if (position < 0) //[-1，0]
            {           //[min,0]
                float factor = mMinAlpha + (1 - mMinAlpha) * (1 + position);
                view.setAlpha(factor);
            } else//[0，1]
            {
                //[min,1]
                float factor = mMinAlpha + (1 - mMinAlpha) * (1 - position);
                view.setAlpha(factor);
            }
        } else
        { // (1,+Infinity]
            view.setAlpha(mMinAlpha);
        }
    }
}

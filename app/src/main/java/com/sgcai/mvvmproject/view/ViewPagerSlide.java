package com.sgcai.mvvmproject.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.viewpager.widget.ViewPager;

/**
 * Created by hinge on 18/3/1.
 */

public class ViewPagerSlide extends ViewPager {
    //是否可以进行滑动
    private boolean isSlide = false;

    //去除页面切换时的滑动翻页效果
    private boolean isSlideAnimation = false;

    public void setSlide(boolean slide) {
        this.isSlide = slide;
    }

    public void setSlideAnimation(boolean slideAnimation) {
        isSlideAnimation = slideAnimation;
    }

    public ViewPagerSlide(Context context) {
        super(context);
    }

    public ViewPagerSlide(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setCurrentItem(int item, boolean smoothScroll) {
        super.setCurrentItem(item, smoothScroll);
    }

    @Override
    public void setCurrentItem(int item) {
        super.setCurrentItem(item, isSlideAnimation);
    }

    @Override
    public boolean onTouchEvent(MotionEvent arg0) {
        if (!isSlide)
            return false;
        else
            return super.onTouchEvent(arg0);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        if (!isSlide)
            return false;
        else
            return super.onInterceptTouchEvent(arg0);
    }
}

package com.example.main.raw.Zdyclass;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.viewpager.widget.ViewPager;

/**
 * 解决ViewPager与DrawerLayout的冲突问题
 * 思路：把第一个Fragment的ViewPager的右滑给禁掉
 * Created by liuyi on 2015/11/13.
 */
public class MyViewPager extends ViewPager {
    private boolean isPagingEnabled = true;
    private float xDistance, xLast;

    private boolean noScroll = false;


    public MyViewPager(Context context) {
        super(context);
    }

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 禁止第一个frament右滑
     *
     * @param ev
     * @return
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (!isPagingEnabled)
            return false;
        if (noScroll) {
            return false;
        }

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                xDistance = 0f;
                xLast = ev.getX();
                break;
            case MotionEvent.ACTION_MOVE:
                final float curX = ev.getX();
                //第一个Fragment禁止右滑
                if (xLast - curX < 0 && getCurrentItem() == 0) {
                    return false;
                }
                //最后一个Fragment禁止左滑
//                if (xLast - curX > 0 && getCurrentItem() == 1) {
//                    return false;
//                }
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public void scrollTo(int x, int y) {
        super.scrollTo(x, y);
    }

    /**
     * 控制Viewpager是否可滑动
     *
     * @param noScroll : true 不能滑动
     */

    public void setNoScroll(boolean noScroll) {
        this.noScroll = noScroll;
    }

    @Override
    public boolean onTouchEvent(MotionEvent arg0) {
        /* return false;//super.onTouchEvent(arg0); */
        if (!isPagingEnabled)
            return false;
        if (noScroll)
            return false;
        else
            return super.onTouchEvent(arg0);
    }

    @Override
    public void setCurrentItem(int item, boolean smoothScroll) {
        super.setCurrentItem(item, smoothScroll);
    }

    @Override
    public void setCurrentItem(int item) {
        super.setCurrentItem(item);
    }


    public void setPagingEnabled(boolean enabled) {
        isPagingEnabled = enabled;
    }




}
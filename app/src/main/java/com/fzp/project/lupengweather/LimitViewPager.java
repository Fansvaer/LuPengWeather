package com.fzp.project.lupengweather;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/10.
 */

public class LimitViewPager extends ViewPager {

    private MyPagerAdapter myPagerAdapter;

    private List<View> mViews = new ArrayList<>();

    public LimitViewPager(Context context) {
        this(context, null);
    }

    public LimitViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        myPagerAdapter = new MyPagerAdapter(mViews);
        setAdapter(myPagerAdapter);
    }

    /**
     * 增加一页，并将该页显示
     */
    public void addPager(@NonNull View view) {
        mViews.add(view);
        myPagerAdapter.notifyDataSetChanged();
        setCurrentItem(mViews.size() - 1, true);
    }

    /**
     * 删除给定位置后面的所有view
     */
    public void deletEnd(int start) {
        int size = mViews.size();
        if (size == 0) {
            return;
        }
        for (int i = size - 1; i > start; i--) {
            mViews.remove(i);
        }
        myPagerAdapter.notifyDataSetChanged();
        setCurrentItem(mViews.size() - 1,true);
    }
}

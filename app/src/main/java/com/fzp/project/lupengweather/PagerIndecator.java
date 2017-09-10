package com.fzp.project.lupengweather;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2017/9/10.
 */

public class PagerIndecator extends HorizontalScrollView {

    private LinearLayout mLinearLayout;

    private CommonCallBack<Integer> commonCallBack;

    private Timer mTimer;

    public PagerIndecator(Context context) {
        this(context, null);
    }

    public PagerIndecator(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PagerIndecator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        HorizontalScrollView.LayoutParams params = new LayoutParams(-1, -1);
        mLinearLayout = new LinearLayout(getContext());
        mLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
        mLinearLayout.setBackgroundColor(0xffffffff);
        addView(mLinearLayout, params);
        mTimer = new Timer();
    }

    public void setCommonCallBack(CommonCallBack<Integer> commonCallBack) {
        this.commonCallBack = commonCallBack;
    }

    public void addButton(String text) {
        Button button = new Button(getContext());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(-2, -1);
        button.setText(text);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (commonCallBack != null) {
                    int index = mLinearLayout.indexOfChild(v);
                    commonCallBack.onEvent(index);
                }
            }
        });
        mLinearLayout.addView(button, params);
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                fullScroll(FOCUS_RIGHT);
            }
        }, 100L);
    }

    public void removeEnd(int start) {
        int leng = mLinearLayout.getChildCount();
        for (int i = leng - 1; i > start; i--) {
            mLinearLayout.removeViewAt(i);
        }
    }

}

package com.fzp.project.lupengweather;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    LimitViewPager mViewPager;

    PagerIndecator mIndicator;

    private List<String> mDatas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = (LimitViewPager) findViewById(R.id.view_pager);
        mIndicator = (PagerIndecator) findViewById(R.id.indicator);
        mIndicator.setCommonCallBack(new CommonCallBack<Integer>() {
            @Override
            public void onEvent(Integer integer) {
                mIndicator.removeEnd(integer);
                mViewPager.deletEnd(integer);
            }
        });
        buildDatas();
        addPager();

    }

    private void addPager(){
        TestListView testListView = new TestListView(this);
        testListView.setData(mDatas);
        testListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                addPager();
            }
        });
        mViewPager.addPager(testListView);
        mIndicator.addButton("测试按钮");
    }

    private void buildDatas(){
        mDatas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mDatas.add("条目" + (i + 1));
        }
    }


}

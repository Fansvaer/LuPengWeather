package com.fzp.project.lupengweather;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager mViewPager;

    private MyPagerAdapter adapter;

    private List<View> mViews = new ArrayList<>();

    private List<String> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        adapter = new MyPagerAdapter(mViews);
        mViewPager.setAdapter(adapter);
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
        mViews.add(testListView);
        adapter.notifyDataSetChanged();
        mViewPager.setCurrentItem(mViews.size()-1,true);

    }

    private void buildDatas(){
        mDatas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mDatas.add("条目" + (i + 1));
        }
    }


}

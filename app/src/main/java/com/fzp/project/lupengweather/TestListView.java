package com.fzp.project.lupengweather;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/9.
 */

public class TestListView extends ListView {

    private List<String> mDatas = new ArrayList<>();
    private ArrayAdapter<String> arrayAdapter;

    public TestListView(Context context) {
        this(context, null);
    }

    public TestListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TestListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
         arrayAdapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,mDatas);
        setAdapter(arrayAdapter);

    }

    public void setData(List<String> datas) {
        this.mDatas.clear();
        this.mDatas.addAll(datas);
        arrayAdapter.notifyDataSetChanged();
    }
}

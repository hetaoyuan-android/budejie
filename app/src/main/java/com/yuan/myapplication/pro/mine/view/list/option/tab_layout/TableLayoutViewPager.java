package com.yuan.myapplication.pro.mine.view.list.option.tab_layout;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yuan.myapplication.R;
import com.yuan.myapplication.pro.mine.view.list.option.tab_layout.adapter.ViewPagerAdapter;
import com.yuan.myapplication.pro.mine.view.list.option.tab_layout.fragment.MyFragment;

import java.util.ArrayList;

public class TableLayoutViewPager extends AppCompatActivity {

    private ViewPager viewPager;

    private ArrayList<MyFragment> fragments;

    private ViewPagerAdapter adapter;

    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_layout_view_pager);
        viewPager = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.tab_layout);
        //初始化数据
        fragments = new ArrayList<>();
        for (int i = 0; i < 12;i ++) {
            fragments.add(new MyFragment("标题" + i, "内容" + i));
        }
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapter);
        //关联
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }
}

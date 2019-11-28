package com.yuan.myapplication.pro.mine.view.list.option.tab_layout.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.yuan.myapplication.pro.mine.view.list.option.tab_layout.fragment.MyFragment;

import java.util.ArrayList;


public class ViewPagerAdapter extends FragmentPagerAdapter {
    private final ArrayList<MyFragment> fragments;

    public ViewPagerAdapter(FragmentManager fm, ArrayList<MyFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragments.get(position).getTitle();
    }
}

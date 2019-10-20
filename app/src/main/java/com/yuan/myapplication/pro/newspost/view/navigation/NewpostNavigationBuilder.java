package com.yuan.myapplication.pro.newspost.view.navigation;

import android.content.Context;
import android.view.ViewGroup;

import com.yuan.myapplication.R;
import com.yuan.myapplication.pro.base.view.navigation.NavigationBuilderAdapter;

public class NewpostNavigationBuilder extends NavigationBuilderAdapter {

    public NewpostNavigationBuilder(Context context){
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.toolbar_newpost_layout;
    }

    @Override
    public void createAndBind(ViewGroup parent) {
        super.createAndBind(parent);
        setImageViewStyle(R.id.iv_left, getLeftIconRes(), getLeftIconOnClickListener());
    }
}

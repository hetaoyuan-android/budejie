package com.yuan.myapplication.pro.newpost.view.navigation;

import android.content.Context;

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
}

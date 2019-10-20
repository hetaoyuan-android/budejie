package com.yuan.myapplication.pro.essence.view.navigation;

import android.content.Context;
import android.view.ViewGroup;

import com.yuan.myapplication.R;
import com.yuan.myapplication.pro.base.view.navigation.NavigationBuilderAdapter;


public class EssenceNavigationBuilder extends NavigationBuilderAdapter {

    public EssenceNavigationBuilder(Context context){
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.toolbar_essence_layout;
    }

    @Override
    public void createAndBind(ViewGroup parent) {
        super.createAndBind(parent);
        setImageViewStyle(R.id.iv_left,getLeftIconRes(),getLeftIconOnClickListener());
        setImageViewStyle(R.id.iv_right,getRightIconRes(),getRightIconOnClickListener());
    }

}

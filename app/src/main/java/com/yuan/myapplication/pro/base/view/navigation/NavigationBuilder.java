package com.yuan.myapplication.pro.base.view.navigation;

import android.view.View;
import android.view.ViewGroup;

/**
 * 构建ToolBar  builder设计模式
 */
public interface NavigationBuilder {
    public NavigationBuilder setTitle(String title);

    public NavigationBuilder setTitle(int title);

    public NavigationBuilder setTitleIcon(int iconRes);

    public NavigationBuilder setLeftIcon(int iconRes);

    public NavigationBuilder setRightIcon(int iconRes);

    public NavigationBuilder setLeftIconOnClickListener(View.OnClickListener onClickListener);

    public NavigationBuilder setRightIconOnClickListener(View.OnClickListener onClickListener);

    public void createAndBind(ViewGroup parent);
}

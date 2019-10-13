package com.yuan.myapplication.pro.base.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yuan.myapplication.mvp.presenter.impl.MvpBasePresenter;
import com.yuan.myapplication.mvp.view.impl.MvpFragment;

public abstract class BaseFragment<P extends MvpBasePresenter> extends MvpFragment<P> {
    //fragment需要缓存视图
    private View viewContent; // 缓存视图
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (viewContent == null) {
            viewContent = inflater.inflate(getContentView(),container, false);
            initContentView(viewContent);
            initData();
        }

        //判断fragment对应的activity是否存在这个试图
        ViewGroup parent = (ViewGroup) viewContent.getParent();
        if (parent != null) {
            parent.removeView(viewContent);
        }
        return viewContent;
    }

    @Override
    public P bindPresenter() {
        return null;
    }

    public abstract int getContentView();
    public abstract void initContentView(View viewContent);


    public void initData(){};
}

package com.yuan.myapplication.pro.base.view;


import com.yuan.myapplication.mvp.presenter.impl.MvpBasePresenter;
import com.yuan.myapplication.mvp.view.impl.MvpActivity;

/**
 * BaseActivtiy---是我们项目的activity
 */
public abstract class BaseActivtiy<P extends MvpBasePresenter> extends MvpActivity<P> {

}

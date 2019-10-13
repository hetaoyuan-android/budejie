package com.yuan.myapplication.mvp.presenter.impl;

import com.yuan.myapplication.mvp.presenter.MvpPresenter;
import com.yuan.myapplication.mvp.view.MvpView;

public class MvpBasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private V view;

    @Override
    public void attachView(V view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        if (view != null) {
            view = null;
        }
    }
}

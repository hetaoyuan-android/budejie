package com.yuan.myapplication.mvp.presenter;

import com.yuan.myapplication.mvp.view.MvpView;

public interface MvpPresenter<V extends MvpView> {
    //绑定View
    public void attachView(V view);

    // 解除绑定
    public void detachView();
}

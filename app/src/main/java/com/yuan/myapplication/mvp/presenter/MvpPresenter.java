package com.yuan.myapplication.mvp.presenter;


import com.yuan.myapplication.mvp.view.MvpView;

/**
 * 中介
 */
public interface MvpPresenter<V extends MvpView> {
    //绑定找房子人(说白了就是我)
    public void attachView(V view);
    //解除绑定(说白了就是不和我联系了)
    public void detachView();
}

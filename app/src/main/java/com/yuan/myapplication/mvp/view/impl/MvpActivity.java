package com.yuan.myapplication.mvp.view.impl;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.yuan.myapplication.mvp.presenter.impl.MvpBasePresenter;
import com.yuan.myapplication.mvp.view.MvpView;

/**
 *  MVP架构集成到我们的activity
 */
public abstract class MvpActivity<P extends MvpBasePresenter> extends AppCompatActivity implements MvpView {

    //mvp的p是动态的
    protected  P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = bindPresenter();
        if (presenter != null) {
            presenter.attachView(this);
        }
    }

    //具体的实现
    public abstract P bindPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachView();
        }
    }
}

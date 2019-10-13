package com.yuan.myapplication.mvp.view.impl;

public abstract class MvpBaseLceView<M> implements MvpLceView<M> {
    @Override
    public void showLoading(boolean pullToRefresh) {

    }

    @Override
    public void showConter() {

    }

    @Override
    public void shouwError(Exception e, boolean pullToRefresh) {

    }

    @Override
    public void showData(M data) {

    }
}

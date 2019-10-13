package com.yuan.myapplication.mvp.view.impl;

import com.yuan.myapplication.mvp.view.MvpView;

/**
 *  请求数据，刷新UI界面
 */
public interface MvpLceView<M> extends MvpView {

    // 显示加载中的视图
    public void showLoading(boolean pullToRefresh);
    //显示contentview
    public void showConter();
    // 加载错误
    public void shouwError(Exception e, boolean pullToRefresh);
    //绑定数据
    public void showData(M data);

}

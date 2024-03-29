package com.yuan.myapplication.pro.mine.presenter;

import android.content.Context;

import com.yuan.myapplication.bean.UserBean;
import com.yuan.myapplication.http.utils.HttpUtils;
import com.yuan.myapplication.pro.base.presenter.BasePresenter;
import com.yuan.myapplication.pro.mine.model.LoginModel;

public class LoginPresenter extends BasePresenter<LoginModel> {

    public LoginPresenter(Context context) {
        super(context);
    }

    @Override
    public LoginModel bindModel() {
        return new LoginModel(getContext());
    }

    public void login(String username, String password, final OnUIThreadListener<UserBean> onUIThreadListener){
        getModel().login(username, password, new HttpUtils.OnHttpResultListener() {
            @Override
            public void onResult(String result) {
                //解析model
                if (result == null){
                    onUIThreadListener.onResult(null);
                }else {
                    UserBean userBean = getGson().fromJson(result,UserBean.class);
                    onUIThreadListener.onResult(userBean);
                }
            }
        });
    }

}

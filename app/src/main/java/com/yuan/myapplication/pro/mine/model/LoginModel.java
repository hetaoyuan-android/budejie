package com.yuan.myapplication.pro.mine.model;

import android.content.Context;

import com.yuan.myapplication.http.impl.RequestParam;
import com.yuan.myapplication.http.impl.SystemHttpCommand;
import com.yuan.myapplication.http.utils.HttpTask;
import com.yuan.myapplication.http.utils.HttpUtils;
import com.yuan.myapplication.pro.base.model.BaseModel;
import com.yuan.myapplication.utils.CommonPropertyUtils;

public class LoginModel extends BaseModel {
    public LoginModel(Context context) {
        super(context);
    }

    public void login(String username, String password, HttpUtils.OnHttpResultListener onHttpResultListener){
        RequestParam requestParam = new RequestParam();
        requestParam.put("username",username);
        requestParam.put("password",password);
        HttpTask httpTask = new HttpTask(CommonPropertyUtils.BASE_NETWORK_URL + "login",requestParam,new SystemHttpCommand(),onHttpResultListener);
        httpTask.execute();
    }

}

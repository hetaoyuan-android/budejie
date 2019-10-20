package com.yuan.myapplication.pro.base.model;

import android.content.Context;

import com.yuan.myapplication.mvp.model.MvpModel;


public abstract class BaseModel implements MvpModel {

    private Context context;

    public BaseModel(Context context){
        this.context = context;
    }

    public String getServerUrl(){
        return "http://api.budejie.com";
    }

}

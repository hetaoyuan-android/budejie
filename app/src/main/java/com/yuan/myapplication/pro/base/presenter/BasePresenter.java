package com.yuan.myapplication.pro.base.presenter;

import android.content.Context;

import com.google.gson.Gson;
import com.yuan.myapplication.mvp.presenter.impl.MvpBasePresenter;
import com.yuan.myapplication.pro.base.model.BaseModel;

public abstract class BasePresenter<M extends BaseModel> extends MvpBasePresenter {

    private Context context;
    private Gson gson;
    private M model;

    public BasePresenter(Context context){
        this.context = context;
        this.gson = new Gson();
        this.model = bindModel();
    }

    public Context getContext() {
        return context;
    }

    public Gson getGson() {
        return gson;
    }

    public M getModel() {
        return model;
    }

    public abstract M bindModel();

    public interface OnUIThreadListener<T>{
        public void onResult(T result);
    }
}

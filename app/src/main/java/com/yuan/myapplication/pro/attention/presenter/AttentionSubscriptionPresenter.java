package com.yuan.myapplication.pro.attention.presenter;

import android.content.Context;
import android.text.TextUtils;

import com.yuan.myapplication.bean.AttentionSubscriptionBean;
import com.yuan.myapplication.http.utils.HttpUtils;
import com.yuan.myapplication.pro.attention.model.AttentionSubscriptionModel;
import com.yuan.myapplication.pro.base.presenter.BasePresenter;
import com.yuan.myapplication.utils.GsonUtils;

import java.util.List;


public class AttentionSubscriptionPresenter extends BasePresenter<AttentionSubscriptionModel> {

    public AttentionSubscriptionPresenter(Context context) {
        super(context);
    }

    @Override
    public AttentionSubscriptionModel bindModel() {
        return new AttentionSubscriptionModel(getContext());
    }

    public void getAttentionSubscriptionList(int type, final OnUIThreadListener<List<AttentionSubscriptionBean>> onUIThreadListener){
        getModel().getAttentionSubscriptionList(type, new HttpUtils.OnHttpResultListener() {
            @Override
            public void onResult(String result) {
                if (TextUtils.isEmpty(result)){
                    onUIThreadListener.onResult(null);
                }else {
                    List<AttentionSubscriptionBean> list = GsonUtils.getList(result,AttentionSubscriptionBean.class);
                    onUIThreadListener.onResult(list);
                }
            }
        });
    }

}

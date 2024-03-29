package com.yuan.myapplication.pro.attention.model;

import android.content.Context;

import com.yuan.myapplication.http.impl.RequestParam;
import com.yuan.myapplication.http.impl.SystemHttpCommand;
import com.yuan.myapplication.http.utils.HttpTask;
import com.yuan.myapplication.http.utils.HttpUtils;
import com.yuan.myapplication.pro.base.model.BaseModel;

public class AttentionSubscriptionModel extends BaseModel {

    private static final String URL_STR = "/api/api_open.php";

    public AttentionSubscriptionModel(Context context) {
        super(context);
    }

    public void getAttentionSubscriptionList(int type, HttpUtils.OnHttpResultListener onHttpResultListener){
        RequestParam requestParam = new RequestParam();
        requestParam.put("a","tag_recommend");
        requestParam.put("action","sub");
        requestParam.put("c","topic");
        requestParam.put("type",type);

        HttpTask httpTask = new HttpTask(getServerUrl().concat(URL_STR),requestParam,new SystemHttpCommand(),onHttpResultListener);
        httpTask.execute();

    }

}

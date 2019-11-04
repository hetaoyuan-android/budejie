package com.yuan.myapplication.http.impl;


import com.yuan.myapplication.http.IHttpCommand;
import com.yuan.myapplication.http.IRequestParam;
import com.yuan.myapplication.http.utils.HttpUtils;

import java.util.HashMap;

public class SystemHttpCommand implements IHttpCommand<HashMap<String,Object>> {

    @Override
    public String execute(String url, IRequestParam<HashMap<String, Object>> requestParam) {
        try {
            return HttpUtils.post(url,requestParam.getRequestParam());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String executeGet(String url) {
        try {
            return HttpUtils.get(url);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

package com.yuan.myapplication.pro.attention.view;

import android.view.View;

import com.yuan.myapplication.R;
import com.yuan.myapplication.pro.base.view.BaseFragment;


/**
 * 关注列表
 */
public class AttentionListFragment extends BaseFragment {


    private int mType = 0;
    private String mTitle;

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public void setType(int type) {
        this.mType = type;
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_attention_list;
    }

    @Override
    public void initContentView(View contentView) {

    }

    @Override
    public void initData() {

    }
}

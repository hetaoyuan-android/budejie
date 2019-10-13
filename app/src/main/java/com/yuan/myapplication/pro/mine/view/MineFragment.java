package com.yuan.myapplication.pro.mine.view;

import android.view.View;
import android.view.ViewGroup;

import com.yuan.myapplication.R;
import com.yuan.myapplication.pro.base.view.BaseFragment;
import com.yuan.myapplication.pro.mine.view.navigation.MineNavigationBuilder;
import com.yuan.myapplication.utils.ToastUtil;

public class MineFragment extends BaseFragment {
    @Override
    public int getContentView() {
        return R.layout.fragment_mine;
    }

    @Override
    public void initContentView(View viewContent) {
        initToolBar(viewContent);
    }

    private void initToolBar(View viewContent){
        MineNavigationBuilder builder = new MineNavigationBuilder(getContext());
        //遇到了问题:方法的顺序要写对
        builder.setModelRes(R.drawable.main_mine_night_model_selector)
                .setModelOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ToastUtil.showToast(getContext(),"点击了setModelRes");
                    }
                })
                .setTitle(R.string.main_mine_title_text)
                .setRightIcon(R.drawable.main_mine_setting_selector)
                .setRightIconOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ToastUtil.showToast(getContext(),"点击了");
                    }
                });
        builder.createAndBind((ViewGroup) viewContent);
    }

}

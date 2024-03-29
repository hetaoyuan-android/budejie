package com.yuan.myapplication.pro.mine.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.yuan.myapplication.R;
import com.yuan.myapplication.pro.base.view.BaseFragment;
import com.yuan.myapplication.pro.base.view.item.DefaultItemBuilder;
import com.yuan.myapplication.pro.mine.view.list.option.ListOptionActivity;
import com.yuan.myapplication.pro.mine.view.navigation.MineNavigationBuilder;
import com.yuan.myapplication.utils.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MineFragment extends BaseFragment {


    @BindView(R.id.ll_list_options)
    LinearLayout llListOptions;
    Unbinder unbinder;

    @Override
    public int getContentView() {
        return R.layout.fragment_mine;
    }

    @Override
    public void initContentView(View viewContent) {
        initToolBar(viewContent);
        initItem(viewContent);
    }

    private void initToolBar(View viewContent) {
        MineNavigationBuilder builder = new MineNavigationBuilder(getContext());
        //遇到了问题:方法的顺序要写对
        builder.setModelRes(R.drawable.main_mine_night_model_selector)
                .setModelOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                })
                .setTitle(R.string.main_mine_title_text)
                .setRightIcon(R.drawable.main_mine_setting_selector)
                .setRightIconOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ToastUtil.showToast(getContext(), "点击了");
                    }
                });
        builder.createAndBind((ViewGroup) viewContent);
    }


    private void initItem(View viewContent) {
        DefaultItemBuilder builder = new DefaultItemBuilder(getContext());
        builder.setLeftIcon(R.drawable.login_unlogin_header)
                .setLeftText(R.string.login_login_text)
                .setRightIcon(R.drawable.item_jiantou)
                .setOnItemClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getActivity(), LoginActivity.class));
                    }
                });
        builder.buildAndBind((ViewGroup) viewContent);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.ll_list_options)
    public void onViewClicked() {
        Intent intent = new Intent();
        intent.setClass(getActivity(), ListOptionActivity.class);
        startActivity(intent);
    }
}

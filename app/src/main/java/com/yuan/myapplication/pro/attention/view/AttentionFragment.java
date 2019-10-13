package com.yuan.myapplication.pro.attention.view;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.yuan.myapplication.R;
import com.yuan.myapplication.pro.attention.view.navigation.AttentionNavigationBuilder;
import com.yuan.myapplication.pro.base.view.BaseFragment;
import com.yuan.myapplication.pro.essence.view.adapter.EssenceAdapter;

import java.util.Arrays;

public class AttentionFragment extends BaseFragment {
    @Override
    public int getContentView() {
        return R.layout.fragment_attention;
    }

    @Override
    public void initContentView(View contentView) {
        ViewPager vp_attention = (ViewPager) contentView.findViewById(R.id.vp_attention);
        String[] titles = getResources().getStringArray(R.array.attention_video_tab);
        EssenceAdapter adapter =
                new EssenceAdapter(getFragmentManager(), Arrays.asList(titles));
        vp_attention.setAdapter(adapter);
        initToolBar(contentView,vp_attention);
    }
    private void initToolBar(View contentView, ViewPager viewPager){
        AttentionNavigationBuilder builder = new AttentionNavigationBuilder(getContext());
        builder.setUpWithViewPager(viewPager)
                .setLeftIcon(R.drawable.main_newpost_audit_btn_selector)
                .setLeftIconOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
        ViewGroup parentView = (ViewGroup) contentView;
        builder.createAndBind(parentView);
    }
}

package com.yuan.myapplication.pro.newpost.view;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;


import com.yuan.myapplication.R;
import com.yuan.myapplication.pro.base.view.BaseFragment;
import com.yuan.myapplication.pro.newspost.view.adapter.NewpostAdapter;
import com.yuan.myapplication.pro.newspost.view.navigation.NewpostNavigationBuilder;
import com.yuan.myapplication.utils.ToastUtil;

import java.util.Arrays;

public class NewpostFragment extends BaseFragment {

    private TabLayout tab_newpost;
    private ViewPager vp_newpost;

    @Override
    public int getContentView() {
        return R.layout.fragment_newpost;
    }

    @Override
    public void initContentView(View viewContent) {
        initToolBar(viewContent);
        this.tab_newpost = (TabLayout) viewContent.findViewById(R.id.tab_essence);
        this.vp_newpost = (ViewPager) viewContent.findViewById(R.id.vp_essence);

    }

    private void initToolBar(View viewContent){
        NewpostNavigationBuilder builder = new NewpostNavigationBuilder(getContext());
        builder.setTitleIcon(R.drawable.main_essence_title)
                .setLeftIcon(R.drawable.main_newpost_audit_btn_selector)
                .setLeftIconOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ToastUtil.showToast(getContext(),"点击了");
                    }
                });
        builder.createAndBind((ViewGroup) viewContent);
    }

    @Override
    public void initData() {
        String[] titles = getResources().getStringArray(R.array.newpost_video_tab);
        NewpostAdapter adapter =
                new NewpostAdapter(getFragmentManager(), Arrays.asList(titles));
        this.vp_newpost.setAdapter(adapter);
        this.tab_newpost.setupWithViewPager(this.vp_newpost);
    }

}

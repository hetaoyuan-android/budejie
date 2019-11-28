package com.yuan.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.entity.LocalImageInfo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * XBanner 使用在引导页控件
 */
public class GuideActivity extends AppCompatActivity {

    @BindView(R.id.xbanner)
    XBanner xbanner;
    @BindView(R.id.btn)
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        ButterKnife.bind(this);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        initView();
    }

    private void initView() {
        List<LocalImageInfo> localImageInfoList = new ArrayList<>();
        localImageInfoList.add(new LocalImageInfo(R.mipmap.we1));
        localImageInfoList.add(new LocalImageInfo(R.mipmap.we2));
        localImageInfoList.add(new LocalImageInfo(R.mipmap.we3));
        xbanner.setBannerData(localImageInfoList);
        xbanner.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                ((ImageView) view).setImageResource(((LocalImageInfo) model).getXBannerUrl());
            }
        });
    }


    @OnClick({R.id.xbanner, R.id.btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.xbanner:
                break;
            case R.id.btn:
                break;
        }
    }
}

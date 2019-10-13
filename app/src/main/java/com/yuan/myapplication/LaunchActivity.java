package com.yuan.myapplication;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.io.ObjectStreamException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LaunchActivity extends AppCompatActivity {

    @BindView(R.id.iv_bg)
    ImageView ivBg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        ButterKnife.bind(this);
        //属性动画
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(ivBg, "scaleX", 0.5f, 1.0f);
        objectAnimator.setDuration(2000);
        objectAnimator.start();
        // 设计模式， 适配器模式  项目中开发需要定义很多的接口
        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                startActivity(new Intent(LaunchActivity.this, MainActivity.class));
                finish();
            }
        });

    }
}

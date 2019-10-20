package com.yuan.myapplication.pro.mine.view;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.yuan.myapplication.R;
import com.yuan.myapplication.bean.UserBean;
import com.yuan.myapplication.mvp.presenter.impl.MvpBasePresenter;
import com.yuan.myapplication.pro.base.presenter.BasePresenter;
import com.yuan.myapplication.pro.base.view.BaseActivtiy;
import com.yuan.myapplication.pro.mine.presenter.LoginPresenter;
import com.yuan.myapplication.pro.mine.view.navigation.LoginNavigationBuilder;
import com.yuan.myapplication.utils.ToastUtil;

public class LoginActivity extends BaseActivtiy implements View.OnClickListener{

    private LoginPresenter loginPresenter;


    private EditText et_phone;
    private EditText et_password;

    @Override
    public MvpBasePresenter bindPresenter() {
        loginPresenter = new LoginPresenter(this);
        return loginPresenter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initToolBar();
        initView();
    }

    private void initToolBar(){
        LinearLayout ll_login = (LinearLayout) findViewById(R.id.ll_login);
        LoginNavigationBuilder builder = new LoginNavigationBuilder(this);
        builder.setLeftIcon(R.drawable.login_close_selector)
                .setTitle(R.string.login_and_register_text)
                .setLeftIconOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
        builder.createAndBind(ll_login);
    }

    private void initView(){
        et_phone = (EditText) findViewById(R.id.et_phone);
        et_password = (EditText) findViewById(R.id.et_password);

        findViewById(R.id.bt_login).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        loginPresenter.login(et_phone.getText().toString(),
                et_password.getText().toString(),
                new BasePresenter.OnUIThreadListener<UserBean>() {
            @Override
            public void onResult(UserBean result) {
                if (result == null){
                    ToastUtil.showToast(LoginActivity.this,"登录失败!");
                }else {
                    ToastUtil.showToast(LoginActivity.this,"登录成功!");
                }
            }
        });
    }
}

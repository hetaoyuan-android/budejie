package com.yuan.myapplication.pro.mine.view.list.option;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TableLayout;

import com.yuan.myapplication.R;
import com.yuan.myapplication.pro.mine.view.list.option.tab_layout.TableLayoutViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ListOptionActivity extends AppCompatActivity {

    @BindView(R.id.btn_tab_layout)
    Button btnTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_option);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_tab_layout)
    public void onViewClicked() {
        startActivity(new Intent(ListOptionActivity.this, TableLayoutViewPager.class));
    }
}

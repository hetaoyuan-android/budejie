package com.yuan.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import com.yuan.myapplication.pro.attention.view.AttentionFragment;
import com.yuan.myapplication.pro.essence.view.EssenceFragment;
import com.yuan.myapplication.pro.mine.view.MineFragment;
import com.yuan.myapplication.pro.newspost.view.NewPostFragment;
import com.yuan.myapplication.pro.publish.view.PublishFragment;
import com.yuan.myapplication.utils.ToastUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements TabHost.OnTabChangeListener {

    @BindView(android.R.id.tabcontent)
    FrameLayout tabcontent;
    @BindView(android.R.id.tabs)
    TabWidget tabs;
    @BindView(android.R.id.tabhost)
    FragmentTabHost tabhost;
    private ArrayList<TabItem> tabItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initTabData();
        initTabHost();
    }

    //初始化Tab数据
    private void initTabData() {
        tabItemList = new ArrayList<TabItem>();
        tabItemList.add(new TabItem(R.drawable.main_bottom_essence_normal, R.drawable.main_bottom_essence_press, R.string.main_essence_text, EssenceFragment.class));
        tabItemList.add(new TabItem(R.drawable.main_bottom_newpost_normal, R.drawable.main_bottom_newpost_press, R.string.main_newpost_text, NewPostFragment.class));
        tabItemList.add(new TabItem(R.drawable.main_bottom_public_normal, R.drawable.main_bottom_public_press, 0, PublishFragment.class));
        tabItemList.add(new TabItem(R.drawable.main_bottom_attention_normal, R.drawable.main_bottom_attention_press, R.string.main_attention_text, AttentionFragment.class));
        tabItemList.add(new TabItem(R.drawable.main_bottom_mine_normal, R.drawable.main_bottom_mine_press, R.string.main_mine_text, MineFragment.class));
    }

    //初始化主页选项卡
    private void initTabHost() {
        // 绑定tabhost(绑定我们的body)
        tabhost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);
        //去掉分割线
        tabhost.getTabWidget().setDividerDrawable(null);
        for (int i = 0; i < tabItemList.size(); i++) {
            TabItem tabItem = tabItemList.get(i);
            //将fragment添加到fragmentTabhost组件
            //newTabSpec名字  setIndicator图片 采用布局文件--tab的样式自己写
            TabHost.TabSpec tabSpec = tabhost.newTabSpec(tabItem.getTitleString()).setIndicator(tabItem.getView());
            // 添加fragment
            //tabSpec选项卡  getFragmentClass具体的fragment  getBundle传参
            tabhost.addTab(tabSpec, tabItem.getFragmentClass(),tabItem.getBundle());
            //按钮设置背景
            tabhost.getTabWidget().getChildAt(i).setBackgroundColor(getResources().getColor(R.color.main_bottom_bg));

            tabhost.setOnTabChangedListener(this);

            //默认选中第一个
            if (i == 0) {
                tabItem.setCheck(true);
            }
        }
    }

    @Override
    public void onTabChanged(String tabId) {
        ToastUtil.showToast(this, tabId);
        //重置tab样式
        for (int i = 0; i < tabItemList.size(); i++) {
            TabItem tabItem = tabItemList.get(i);
            if (tabId.equals(tabItem.getTitleString())) {
                //选中
                tabItem.setCheck(true);
            } else {
                tabItem.setCheck(false);
            }
        }
    }

    class TabItem {
        @BindView(R.id.iv_tab)
        ImageView ivTab;
        @BindView(R.id.tv_tab)
        TextView tvTab;
        //正常显示图片
        private int imageNormal;
        //选中
        private int imagePress;
        //tab名字
        private int title;
        private String titleString;

        private Class<? extends Fragment> fragmentClass;

        private View view;
        private ImageView imageView;
        private TextView textView;

        private Bundle bundle;

        public TabItem(int imageNormal, int imagePress, int title, Class<? extends Fragment> fragmentClass) {
            this.imageNormal = imageNormal;
            this.imagePress = imagePress;
            this.title = title;
            this.fragmentClass = fragmentClass;
        }

        public Class<? extends Fragment> getFragmentClass() {
            return fragmentClass;
        }

        public void setFragmentClass(Class<? extends Fragment> fragmentClass) {
            this.fragmentClass = fragmentClass;
        }

        public int getImageNormal() {
            return imageNormal;
        }

        public void setImageNormal(int imageNormal) {
            this.imageNormal = imageNormal;
        }

        public int getImagePress() {
            return imagePress;
        }

        public void setImagePress(int imagePress) {
            this.imagePress = imagePress;
        }

        public int getTitle() {
            return title;
        }

        public void setTitle(int title) {
            this.title = title;
        }

        public String getTitleString() {
            if (title == 0) {
                return "";
            }
            if (TextUtils.isEmpty(titleString)) {
                titleString = getString(title);
            }
            return titleString;
        }

        public void setTitleString(String titleString) {
            this.titleString = titleString;
        }

        public Bundle getBundle() {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString("title", getTitleString());
            return bundle;
        }

        public void setBundle(Bundle bundle) {
            this.bundle = bundle;
        }

        //还需要提供一个切换tab方法,改变tab的样式
        public void setCheck(boolean isChecked) {
            if (imageView != null) {
                if (isChecked) {
                    imageView.setImageResource(imagePress);
                } else {
                    imageView.setImageResource(imageNormal);
                }
            }

            if (textView != null && title != 0) {
                if (isChecked) {
                    textView.setTextColor(getResources().getColor(R.color.main_bottom_text_select));
                } else {
                    textView.setTextColor(getResources().getColor(R.color.main_bottom_text_normal));
                }
            }
        }

        public View getView() {
            if (this.view == null) {
                this.view = getLayoutInflater().inflate(R.layout.view_tab_indicator, null);
                this.imageView = this.view.findViewById(R.id.iv_tab);
                this.textView = this.view.findViewById(R.id.tv_tab);
                //判断资源是否存在
                if (this.title == 0) {
                    this.textView.setVisibility(View.GONE);
                } else {
                    this.textView.setVisibility(View.VISIBLE);
                    this.textView.setText(getTitleString());
                }
                //绑定资源默认资源
                this.imageView.setImageResource(imageNormal);
            }
            return this.view;
        }
    }
}

package com.example.machao14.tablyoutdemo;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<View> viewList = new ArrayList<>(3);
    private TabLayout.Tab tab1;
    private TabLayout.Tab tab2;
    private TabLayout.Tab tab3;

    private String[] strs = {"首页","视频","我的"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View view = null;
        view = getLayoutInflater().inflate(R.layout.view1,null);
        viewList.add(view);

        view = getLayoutInflater().inflate(R.layout.view2,null);
        viewList.add(view);

        view = getLayoutInflater().inflate(R.layout.view3,null);
        viewList.add(view);
        
        initView();
        initEvn();

    }

    private void initEvn() {

        mTabLayout.addOnTabSelectedListener(listener);

    }

    private void initView() {
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) findViewById(R.id.vp_viewpager);
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return viewList.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view = viewList.get(position);
                container.addView(view);
                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return strs[position];
            }
        });

//
//        tab1 = mTabLayout.newTab();
//        tab1.setText("首页");
//
//        tab2 = mTabLayout.newTab();
//        tab2.setText("视频");
//
//        tab3 = mTabLayout.newTab();
//        tab3.setText("我的");
//
//        mTabLayout.addTab(tab1);
//        mTabLayout.addTab(tab2);
//        mTabLayout.addTab(tab3);
    }

    private TabLayout.OnTabSelectedListener listener = new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            //选择的tab

            Log.e("TT","onTabSelected:" + tab.getText().toString());

        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {
            //离开的那个tab
            Log.e("TT","onTabUnselected" + tab.getText().toString());
        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {
            //再次选择tab
            Log.e("TT","onTabReselected" + tab.getText().toString());
        }
    };
}

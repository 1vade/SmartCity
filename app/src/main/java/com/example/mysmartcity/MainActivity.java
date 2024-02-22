package com.example.mysmartcity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.mysmartcity.adapter.MyAdapter;
import com.example.mysmartcity.fragment.DataFragment;
import com.example.mysmartcity.fragment.HomeFragment;
import com.example.mysmartcity.fragment.MeFragment;
import com.example.mysmartcity.fragment.NewsFragment;
import com.example.mysmartcity.fragment.ServiceFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Fragment> mFragments;
    private ViewPager viewPager;
    private TabLayout mTabLayout;
    private List<String> mTitle;
    private Integer[] mImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        initView();
    }

    private void initView() {
        mTabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);

        mFragments = new ArrayList<>();
        mFragments.add(new HomeFragment());
        mFragments.add(new ServiceFragment());
        mFragments.add(new DataFragment());
        mFragments.add(new NewsFragment());
        mFragments.add(new MeFragment());

        mTitle = new ArrayList<String>();
        mTitle.add("首页");
        mTitle.add("全部服务");
        mTitle.add("数据分析");
        mTitle.add("新闻");
        mTitle.add("个人中心");

        mImg = new Integer[]{
                R.drawable.ic_1,
                R.drawable.ic_2,
                R.drawable.ic_3,
                R.drawable.ic_4,
                R.drawable.ic_5
        };

        MyAdapter adapt = new MyAdapter(getSupportFragmentManager(), mFragments, mTitle);
        viewPager.setAdapter(adapt);

        mTabLayout.setupWithViewPager(viewPager);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }

        });
    }


}


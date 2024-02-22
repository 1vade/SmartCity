package com.example.mysmartcity.fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mysmartcity.R;
import com.example.mysmartcity.adapter.NewsAdapter;
import com.example.mysmartcity.fragment.news.New1Fragment;
import com.example.mysmartcity.fragment.news.New2Fragment;
import com.example.mysmartcity.fragment.news.New3Fragment;
import com.example.mysmartcity.fragment.news.New4Fragment;
import com.example.mysmartcity.fragment.news.New5Fragment;
import com.google.android.material.tabs.TabLayout;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;
import java.util.List;


public class NewsFragment extends Fragment {
    private List<Fragment> newsFragments;
    private List<String> newsTitle;
    private List<Integer> banner_data;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        initData();
        initView();

        View view = inflater.inflate(R.layout.fragment_news, container, false);


        Banner banner = view.findViewById(R.id.newsBanner);
        banner.setAdapter(new BannerImageAdapter<Integer>(banner_data) {
            @Override
            public void onBindView(BannerImageHolder holder, Integer data, int position, int size) {
                holder.imageView.setImageResource(data);
            }
        });
        banner.isAutoLoop(true);
        banner.setIndicator(new CircleIndicator(getContext()));
        banner.setScrollBarFadeDuration(1000);
        banner.setIndicatorSelectedColor(Color.WHITE);
        banner.start();

        ViewPager newsViewPager = view.findViewById(R.id.newsViewpager);
        TabLayout newsTabLayout = view.findViewById(R.id.newsTablayout);
        NewsAdapter adapter = new NewsAdapter(getFragmentManager(), newsFragments, newsTitle);
        newsViewPager.setAdapter(adapter);

        newsTabLayout.setupWithViewPager(newsViewPager);

        newsViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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
        return view;
    }
    private void initData() {
        banner_data = new ArrayList<>();
        banner_data.add(R.drawable.banner1);
        banner_data.add(R.drawable.banner2);
        banner_data.add(R.drawable.banner3);

    }
    private void initView() {
        newsFragments = new ArrayList<>();
        newsFragments.add(new New5Fragment());
        newsFragments.add(new New2Fragment());
        newsFragments.add(new New3Fragment());
        newsFragments.add(new New4Fragment());

        newsTitle = new ArrayList<String>();
        newsTitle.add("主题");
        newsTitle.add("主题2");
        newsTitle.add("主题3");
        newsTitle.add("主题4");

    }
}
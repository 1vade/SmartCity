package com.example.mysmartcity.adapter;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class NewsAdapter extends FragmentPagerAdapter {
    private List<Fragment> newsFragments;
    private List<String> newsTitle;

    public NewsAdapter( FragmentManager fm,List<Fragment> newsFragments, List<String> newsTitle) {
        super(fm);
        this.newsFragments=newsFragments;
        this.newsTitle=newsTitle;

    }


    @Override
    public Fragment getItem(int position) {
        return newsFragments.get(position);
    }

    @Override
    public int getCount() {
        return newsFragments.size();
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return newsTitle.get(position);
    }
}

package com.example.mysmartcity.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class MyAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragments;
    private List<String> mTitle;

    public MyAdapter(FragmentManager fm, List<Fragment> mFragments, List<String> mTitle) {
        super(fm);
        this.mFragments=mFragments;
        this.mTitle=mTitle;

    }


    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle.get(position);
    }
}

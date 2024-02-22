package com.example.mysmartcity.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

import com.example.mysmartcity.R;
import com.example.mysmartcity.adapter.GridViewAdapter;
import com.example.mysmartcity.adapter.Icon;
import com.example.mysmartcity.adapter.MyAdapter;

import java.util.ArrayList;


public class ServiceFragment extends Fragment {

    private ArrayList<Icon> mData = null;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_service, container, false);
        initViews(view);


        return view;

    }

    private void initViews(View view) {
        GridView gv1 = view.findViewById(R.id.gv1);
        String[] name1 = {"智慧交通", "便民服务", "垃圾分类", "智慧交通", "智慧交通", "智慧交通", "智慧交通", "智慧交通"};
        int[] images1 = {R.drawable.bus, R.drawable.bus, R.drawable.bus, R.drawable.bus, R.drawable.bus, R.drawable.bus, R.drawable.bus, R.drawable.bus};
        GridViewAdapter gridViewAdapter1 = new GridViewAdapter(getContext(), name1, images1);
        gv1.setAdapter(gridViewAdapter1);

        GridView gv2 = view.findViewById(R.id.gv2);
        String[] name2 = {"政府热线", "便民服务", "水电费", "医保", "智慧交通"};
        int[] image2 = {R.drawable.bus, R.drawable.star, R.drawable.ic_1, R.drawable.ic_2, R.drawable.ic_3};
        GridViewAdapter gridViewAdapter2 = new GridViewAdapter(getContext(), name2, image2);
        gv2.setAdapter(gridViewAdapter2);

        GridView gv3 = view.findViewById(R.id.gv3);
        String[] name3 = {"政府热线", "便民服务", "水电费", "医保", "智慧交通"};
        int[] image3 = {R.drawable.ic_4, R.drawable.ic_5, R.drawable.ic_comment, R.drawable.ic_close, R.drawable.ic_3};
        GridViewAdapter gridViewAdapter3 = new GridViewAdapter(getContext(), name3, image3);
        gv3.setAdapter(gridViewAdapter3);
    }

}
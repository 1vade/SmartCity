package com.example.mysmartcity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mysmartcity.R;

public class GridViewAdapter extends BaseAdapter {
    private Context context;
    String[] names;
    int[] images;

    public GridViewAdapter(Context context, String[] names, int[] images) {
        this.context = context;
        this.names = names;
        this.images = images;
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int position) {
        return names[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_grid_icon, null);
        ImageView icon = view.findViewById(R.id.icon);
        TextView tv_name = view.findViewById(R.id.tv_name);
        icon.setImageResource(images[position]);
        tv_name.setText(names[position]);
        return view;

    }
}

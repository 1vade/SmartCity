package com.example.mysmartcity.fragment.news;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mysmartcity.R;

import java.util.List;


public class New1Fragment extends Fragment {
    private Integer[] icons = {R.drawable.banner1, R.drawable.banner2, R.drawable.banner3};
    private String[] names={"新闻标题1","新闻标题2","新闻标题3"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new1, container, false);
        ListView listview=view.findViewById(R.id.listview);
        MyBaseAdapter baseAdapter=new MyBaseAdapter();
        listview.setAdapter(baseAdapter);
        return view;
    }
    class MyBaseAdapter extends BaseAdapter{

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
            View view=View.inflate(getContext(), R.layout.myitem,null);
            ImageView image=view.findViewById(R.id.image);
            TextView name=view.findViewById(R.id.name);
            image.setImageResource(icons[position]);
            name.setText(names[position]);
            return view;
        }
    }
}
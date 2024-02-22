package com.example.mysmartcity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mysmartcity.R;

import java.util.ArrayList;
import java.util.List;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.MyHolder> {
    private static String URL = "http://124.93.196.45:10001";
    private List<NewsInfo.RowsBean> mRowsBeanList = new ArrayList<>();
    private Context mContext;

    public NewsListAdapter(Context context) {
        this.mContext = context;
    }

    public void setListRows(List<NewsInfo.RowsBean> list) {
        this.mRowsBeanList = list;
        notifyDataSetChanged();
    }


    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.new_item, null);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        NewsInfo.RowsBean rowsBean = mRowsBeanList.get(position);

        holder.title.setText(rowsBean.getTitle());
        holder.date.setText(rowsBean.getPublishDate());
        Glide.with(mContext).load(URL+rowsBean.getCover()).into(holder.cover);

    }

    @Override
    public int getItemCount() {
        return mRowsBeanList.size();
    }

    static class MyHolder extends RecyclerView.ViewHolder {
        ImageView cover;
        TextView title;
        TextView date;

        public MyHolder( View itemView) {
            super(itemView);
            cover=itemView.findViewById(R.id.cover);
            title=itemView.findViewById(R.id.title);
            date=itemView.findViewById(R.id.date);
        }
    }
}

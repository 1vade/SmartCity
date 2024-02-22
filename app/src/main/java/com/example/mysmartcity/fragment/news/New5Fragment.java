package com.example.mysmartcity.fragment.news;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mysmartcity.R;
import com.example.mysmartcity.adapter.NewsInfo;
import com.example.mysmartcity.adapter.NewsListAdapter;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class New5Fragment extends Fragment {
    private static String URL = "http://124.93.196.45:10001/prod-api/api/metro/press/press/list?type=5&pageNum=1&pageSize=7";
    private RecyclerView mRecyclerView;
    private NewsListAdapter mNewsListAdapter;

    private Handler mHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 100) {
                String data = (String) msg.obj;
                NewsInfo newsInfo = new Gson().fromJson(data, NewsInfo.class);

                if (null != mNewsListAdapter) {
                    mNewsListAdapter.setListRows(newsInfo.getRows());
                }
            }
        }
    };

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news5, container, false);
        mRecyclerView = view.findViewById(R.id.recyclerView);
        mNewsListAdapter = new NewsListAdapter(getContext());
        mRecyclerView.setAdapter(mNewsListAdapter);
        getHttpData();
        return view;
    }

    private void getHttpData() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(URL)
                .get()
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("-------------", "onFailure: " + e.toString());
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String data = response.body().string();
                Message message = new Message();
                message.what = 100;
                message.obj = data;
                mHandler.sendMessage(message);
            }
        });
    }
}
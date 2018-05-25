package com.ylxt.gpmanagement.work.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ylxt.gpmanagement.R;
import com.ylxt.gpmanagement.base.ui.activity.BaseMvpActivity;
import com.ylxt.gpmanagement.work.data.gson.XinData;
import com.ylxt.gpmanagement.work.presenter.ShouxinPresenter;
import com.ylxt.gpmanagement.work.presenter.view.ShouxinView;
import com.ylxt.gpmanagement.work.ui.adapter.RecyclerViewXinAdapter;

import java.util.ArrayList;
import java.util.List;

public class ShouXinActivity extends BaseMvpActivity<ShouxinPresenter> implements ShouxinView {


    private static final String TAG = "ShouXinActivity";
    private RecyclerView mRecyclerView;
    private RecyclerViewXinAdapter mAdapter;
    private List<XinData> mDatas = new ArrayList<>();
    private ImageView mImBack;
    private ImageView mImAdd;
    private TextView mTitle;
    private int type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shou_xin);

        mPresenter = new ShouxinPresenter();
        mPresenter.mView = this;
        type = getIntent().getIntExtra("type", 0);

        mTitle = findViewById(R.id.tv_title);

        mRecyclerView = findViewById(R.id.rv_shouxin);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new RecyclerViewXinAdapter(this, mDatas, type);
        mRecyclerView.setAdapter(mAdapter);

        mImBack = findViewById(R.id.im_back);
        mImBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mImAdd = findViewById(R.id.im_add);
        mImAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ShouXinActivity.this, SendActivity.class));
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        if (type == 0) {
            mTitle.setText("收信箱");
            mPresenter.getShouxin();
        } else {
            mTitle.setText("发信箱");
            mPresenter.getFaXin();
        }
    }

    @Override
    public void onShouxinSucc(List<XinData> data) {
        mDatas.clear();
        mDatas.addAll(data);
        mAdapter.notifyDataSetChanged();
        Log.d(TAG, "onShouxinSucc: " + data.size());
    }
}

package com.ylxt.gpmanagement.teacher.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.ylxt.gpmanagement.R;
import com.ylxt.gpmanagement.base.common.Info;
import com.ylxt.gpmanagement.base.ui.activity.BaseMvpActivity;
import com.ylxt.gpmanagement.teacher.presenter.ZhongqiPresenter;
import com.ylxt.gpmanagement.teacher.presenter.view.ZhongqiView;
import com.ylxt.gpmanagement.teacher.ui.adapter.ZhongqiAdapter;
import com.ylxt.gpmanagement.work.data.gson.ZhongqiData;

import java.util.ArrayList;
import java.util.List;

public class TeacherZhongqiActivity extends BaseMvpActivity<ZhongqiPresenter> implements ZhongqiView {

    private RecyclerView mRecyclerView;
    private ZhongqiAdapter mAdapter;
    private List<ZhongqiData> mDatas = new ArrayList<>();

    private static final String TAG = "TeacherZhongqiActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_zhongqi);

        mPresenter = new ZhongqiPresenter();
        mPresenter.mView = this;

        mRecyclerView = findViewById(R.id.rv_zhongqi);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new ZhongqiAdapter(this, mDatas);
        mAdapter.setItemClickedListener(new ZhongqiAdapter.OnItemClickedListener() {
            @Override
            public void onItemClicked(int position) {
                Intent intent = new Intent(TeacherZhongqiActivity.this, ZhongqiShowActivity.class);
                Info.mZhongqiData = mDatas.get(position);

                startActivity(intent);
                finish();
            }
        });
        mRecyclerView.setAdapter(mAdapter);

        ImageView imBack = findViewById(R.id.im_back);
        imBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.getZhongqi();
    }


    @Override
    public void onGetZhongqi(List<ZhongqiData> data) {

        mDatas.clear();
        mDatas.addAll(data);
        mAdapter.notifyDataSetChanged();
        Log.d(TAG, "onGetZhongqi: " + data.size());
    }
}

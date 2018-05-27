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
import com.ylxt.gpmanagement.teacher.presenter.DinggaoPresenter;
import com.ylxt.gpmanagement.teacher.presenter.ZhongqiPresenter;
import com.ylxt.gpmanagement.teacher.presenter.view.DinggaoView;
import com.ylxt.gpmanagement.teacher.presenter.view.ZhongqiView;
import com.ylxt.gpmanagement.teacher.ui.adapter.DinggaoAdapter;
import com.ylxt.gpmanagement.teacher.ui.adapter.ZhongqiAdapter;
import com.ylxt.gpmanagement.work.data.gson.Dinggao;
import com.ylxt.gpmanagement.work.data.gson.DinggaoData;
import com.ylxt.gpmanagement.work.data.gson.ZhongqiData;

import java.util.ArrayList;
import java.util.List;

public class TeacherDinggaoActivity extends BaseMvpActivity<DinggaoPresenter> implements DinggaoView {

    private RecyclerView mRecyclerView;
    private DinggaoAdapter mAdapter;
    private List<DinggaoData> mDatas = new ArrayList<>();

    private static final String TAG = "TeacherDinggaoActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_dinggao);

        mPresenter = new DinggaoPresenter();
        mPresenter.mView = this;

        mRecyclerView = findViewById(R.id.rv_dinggao);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new DinggaoAdapter(this, mDatas);
        mAdapter.setItemClickedListener(new DinggaoAdapter.OnItemClickedListener() {
            @Override
            public void onItemClicked(int position) {
                Intent intent = new Intent(TeacherDinggaoActivity.this, DinggaoShowActivity.class);
                Info.mDinggaoData= mDatas.get(position);
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
        mPresenter.getDinggao();
    }


    @Override
    public void onGetDinggao(List<DinggaoData> data) {
        mDatas.clear();
        mDatas.addAll(data);
        mAdapter.notifyDataSetChanged();
        Log.d(TAG, "onGetDinggao: " + data.size());
    }
}

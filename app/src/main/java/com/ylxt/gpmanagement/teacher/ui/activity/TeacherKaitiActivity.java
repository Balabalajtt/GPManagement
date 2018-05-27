package com.ylxt.gpmanagement.teacher.ui.activity;

import android.app.Dialog;
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
import com.ylxt.gpmanagement.teacher.presenter.KaitiPresenter;
import com.ylxt.gpmanagement.teacher.presenter.view.KaitiView;
import com.ylxt.gpmanagement.teacher.ui.adapter.TeKaitiAdapter;
import com.ylxt.gpmanagement.work.data.gson.KaitiData;

import java.util.ArrayList;
import java.util.List;

public class TeacherKaitiActivity extends BaseMvpActivity<KaitiPresenter> implements KaitiView {

    private RecyclerView mRecyclerView;
    private TeKaitiAdapter mAdapter;
    private List<KaitiData> mDatas = new ArrayList<>();

    private static final String TAG = "TeacherKaitiActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_kaiti);

        mPresenter = new KaitiPresenter();
        mPresenter.mView = this;

        mRecyclerView = findViewById(R.id.rv_kaiti);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new TeKaitiAdapter(this, mDatas);
        mAdapter.setItemClickedListener(new TeKaitiAdapter.OnItemClickedListener() {
            @Override
            public void onItemClicked(int position) {
                Intent intent = new Intent(TeacherKaitiActivity.this, KaitiShowActivity.class);
                Info.mKaitiData = mDatas.get(position);

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
        mPresenter.getKaiti();
    }

    @Override
    public void onGetKaiti(List<KaitiData> data) {
        mDatas.clear();
        mDatas.addAll(data);
        mAdapter.notifyDataSetChanged();
        Log.d(TAG, "onGetKaiti: " + data.size());
    }
}

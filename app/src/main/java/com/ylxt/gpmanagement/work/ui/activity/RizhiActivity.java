package com.ylxt.gpmanagement.work.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.ylxt.gpmanagement.R;
import com.ylxt.gpmanagement.base.ui.activity.BaseMvpActivity;
import com.ylxt.gpmanagement.work.data.gson.RizhiData;
import com.ylxt.gpmanagement.work.presenter.RizhiPresenter;
import com.ylxt.gpmanagement.work.presenter.view.RizhiView;
import com.ylxt.gpmanagement.work.ui.adapter.RiZhiAdapter;

import java.util.ArrayList;
import java.util.List;

public class RizhiActivity extends BaseMvpActivity<RizhiPresenter> implements RizhiView {

    private RecyclerView mRecyclerView;
    private RiZhiAdapter mAdapter;
    private List<RizhiData> mDatas = new ArrayList<>();
    private ImageView mImBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rizhi);
        mPresenter = new RizhiPresenter();
        mPresenter.mView = this;

        mRecyclerView = findViewById(R.id.rv_rizhi);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new RiZhiAdapter(this, mDatas);
        mRecyclerView.setAdapter(mAdapter);

        mImBack = findViewById(R.id.im_back);
        mImBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mPresenter.getRizhi();

    }

    @Override
    public void onGetRizhi(List<RizhiData> data) {
        mDatas.clear();
        mDatas.addAll(data);
        mAdapter.notifyDataSetChanged();
    }
}

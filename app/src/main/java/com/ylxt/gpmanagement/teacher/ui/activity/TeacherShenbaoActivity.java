package com.ylxt.gpmanagement.teacher.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.ylxt.gpmanagement.R;
import com.ylxt.gpmanagement.base.common.Info;
import com.ylxt.gpmanagement.base.ui.activity.BaseMvpActivity;
import com.ylxt.gpmanagement.teacher.presenter.ShenbaoPresenter;
import com.ylxt.gpmanagement.teacher.presenter.view.ShenbaoView;
import com.ylxt.gpmanagement.teacher.ui.adapter.TeShenbaoAdapter;
import com.ylxt.gpmanagement.work.data.gson.SubjectData;

import java.util.ArrayList;
import java.util.List;

public class TeacherShenbaoActivity extends BaseMvpActivity<ShenbaoPresenter> implements ShenbaoView {

    private RecyclerView mRecyclerView;
    private TeShenbaoAdapter mAdapter;
    private List<SubjectData> mDatas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_shenbao);
        mPresenter = new ShenbaoPresenter();
        mPresenter.mView = this;

        mRecyclerView = findViewById(R.id.rv_shenbao);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new TeShenbaoAdapter(this, mDatas);
        mAdapter.setItemClickedListener(new TeShenbaoAdapter.OnItemClickedListener() {
            @Override
            public void onItemClicked(int position) {
                Intent intent = new Intent(TeacherShenbaoActivity.this, ShenbaoShowActivity.class);
//                intent.putExtra("shenbao", mDatas.get(position));
                Info.mSubjectData = mDatas.get(position);

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
        mPresenter.getShenbao();
    }

    @Override
    public void onGetShenbao(List<SubjectData> data) {
        mDatas.clear();
        mDatas.addAll(data);
        mAdapter.notifyDataSetChanged();
    }
}

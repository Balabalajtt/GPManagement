package com.ylxt.gpmanagement.work.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ylxt.gpmanagement.R;
import com.ylxt.gpmanagement.base.ui.activity.BaseMvpActivity;
import com.ylxt.gpmanagement.work.data.gson.SubjectData;
import com.ylxt.gpmanagement.work.presenter.XuantiPresenter;
import com.ylxt.gpmanagement.work.presenter.view.XuantiView;
import com.ylxt.gpmanagement.work.ui.adapter.RecyclerViewAdapter;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class XuantiActivity extends BaseMvpActivity<XuantiPresenter> implements XuantiView {

    private static final String TAG = "XuantiActivity";

    private RecyclerView mRvXuanti;
    private List<SubjectData> mDataList = new ArrayList<>();
    private RecyclerViewAdapter mAdapter;

    private LinearLayout llShow;
    private TextView mTvTitle;
    private TextView mTvType;
    private TextView mTvSource;
    private TextView mTvDiff;
    private TextView mTvWork;
    private TextView mTvStatus;

    private TextView mTvError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xuanti);

        mPresenter = new XuantiPresenter();
        mPresenter.mView = this;

        llShow = findViewById(R.id.ll_show);
        mTvTitle = findViewById(R.id.tv_title);
        mTvType = findViewById(R.id.tv_type);
        mTvSource = findViewById(R.id.tv_source);
        mTvDiff = findViewById(R.id.tv_difficult);
        mTvWork = findViewById(R.id.tv_work);
        mTvStatus = findViewById(R.id.tv_status);

        mTvError = findViewById(R.id.tv_error);

        ImageView imBack = findViewById(R.id.im_back);
        imBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mRvXuanti = findViewById(R.id.rv_xuanti);
        mRvXuanti.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new RecyclerViewAdapter(this, mDataList);
        mAdapter.setBtOnClickListener(new RecyclerViewAdapter.BtOnClickListener() {
            @Override
            public void onBtClick(int position) {
                mPresenter.chooseSubject(mDataList.get(position).id);
            }
        });
        mRvXuanti.setAdapter(mAdapter);

        mPresenter.checkXuanti();


    }

    @Override
    public void onChooseSubject(int status, String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        if (status == 1) {
            finish();
        }
    }

    @Override
    public void onGetSubjects(List<SubjectData> data) {
        mDataList.clear();
        mDataList.addAll(data);
        mAdapter.notifyDataSetChanged();
        Log.d(TAG, "onGetSubjects: " + mDataList.size());
    }

    //还没选
    @Override
    public void onUnChoose() {
        mPresenter.getSubjects();
        mRvXuanti.setVisibility(View.VISIBLE);
        llShow.setVisibility(View.GONE);
        mTvError.setVisibility(View.GONE);
    }

    //选过 展示选过的课题
    @Override
    public void onChoosed(SubjectData data) {
        mRvXuanti.setVisibility(View.GONE);
        llShow.setVisibility(View.VISIBLE);
        mTvError.setVisibility(View.GONE);
        mTvTitle.setText("课题名称：" + data.subjectName);
        mTvType.setText("课题类型：" + data.subjectType);
        mTvSource.setText("课题来源：" + data.source);
//        mTvDiff.setText("课题难度：");
//        mTvWork.setText("课题工作量大小：");
        mTvStatus.setText("当前状态：" + (data.status == 1 ? "已选择" : "未知"));

    }

    //申报过课题，不能再选
    @Override
    public void onBujinqu(String msg) {
        mRvXuanti.setVisibility(View.GONE);
        llShow.setVisibility(View.GONE);
        mTvError.setVisibility(View.VISIBLE);
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}

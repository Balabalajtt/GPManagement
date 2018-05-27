package com.ylxt.gpmanagement.work.ui.activity;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.ylxt.gpmanagement.R;
import com.ylxt.gpmanagement.base.common.FileUtil;
import com.ylxt.gpmanagement.base.ui.activity.BaseMvpActivity;
import com.ylxt.gpmanagement.work.data.gson.DinggaoData;
import com.ylxt.gpmanagement.work.presenter.DinggaoPresenter;
import com.ylxt.gpmanagement.work.presenter.view.DinggaoView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class DinggaoActivity extends BaseMvpActivity<DinggaoPresenter> implements View.OnClickListener, DinggaoView {

    private Button mBtTijiao;
    private Button mBtLunwenChoose;
    private Button mBtFujianChoose;
    private TextView mTvLunwen;
    private TextView mTvFujian;

    private String mLunwenPath = "";
    private File mLunwenFile = null;
    private String mFujianPath = "";
    private File mFujianFile = null;

    private ImageView mImBack;
    private TextView mTvTitle;
    private ScrollView mScrollView;
    private TextView mTvTishi;

    private static final String TAG = "DinggaoActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinggao);

        mPresenter = new DinggaoPresenter();
        mPresenter.mView = this;

        mScrollView = findViewById(R.id.scroll_view);
        mTvTishi = findViewById(R.id.tv_tishi);

        mImBack = findViewById(R.id.im_back);
        mBtTijiao = findViewById(R.id.bt_tijiao);
        mBtLunwenChoose = findViewById(R.id.bt_lunwen);
        mTvLunwen = findViewById(R.id.tv_lunwen);
        mBtFujianChoose = findViewById(R.id.bt_fujian);
        mTvFujian = findViewById(R.id.tv_fujian);
        mImBack.setOnClickListener(this);
        mBtTijiao.setOnClickListener(this);
        mBtLunwenChoose.setOnClickListener(this);
        mBtFujianChoose.setOnClickListener(this);

        mTvTitle = findViewById(R.id.tv_title);


        mPresenter.checkDinggao();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.im_back:
                finish();
                break;
            case R.id.bt_lunwen:
                openFileManager(1);
                break;
            case R.id.bt_fujian:
                openFileManager(2);
                break;
            case R.id.bt_tijiao:
                List<MultipartBody.Part> parts = new ArrayList<>();
                if (mLunwenFile != null) {
                    RequestBody lunwenFile = RequestBody
                            .create(MediaType.parse("*/*"), mLunwenFile);
                    MultipartBody.Part lunwen = MultipartBody.Part
                            .createFormData("file", mLunwenFile.getName(), lunwenFile);
                    parts.add(lunwen);
                    if (mFujianPath != null) {
                        RequestBody fujianFile = RequestBody
                                .create(MediaType.parse("*/*"), mFujianFile);
                        MultipartBody.Part fujian = MultipartBody.Part
                                .createFormData("file", mLunwenFile.getName(), fujianFile);
                        parts.add(fujian);
                    }
                    mPresenter.postDinggao(parts);
                } else {
                    Toast.makeText(this, "请选择论文文件", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private void openFileManager(int requestCode) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");//无类型限制
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(intent, requestCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            Uri uri = data.getData();
            if (requestCode == 1) {
                mLunwenPath = FileUtil.getPathByUri(this, uri);
                if (mLunwenPath != null) {
                    mLunwenFile = new File(mLunwenPath);
                    if (mLunwenFile.exists()) {
                        mTvLunwen.setText("文件选择成功：" + mLunwenFile.getName());
                        return;
                    }
                }
                mTvLunwen.setText("文件选择失败");
            } else {
                mFujianPath = FileUtil.getPathByUri(this, uri);
                if (mFujianPath != null) {
                    mFujianFile = new File(mFujianPath);
                    if (mFujianFile.exists()) {
                        mTvFujian.setText("文件选择成功：" + mFujianFile.getName());
                        return;
                    }
                }
                mTvFujian.setText("文件选择失败");
            }
        }
    }


    @Override
    public void onTianDinggao(int status, String msg) {

    }

    @Override
    public void onShowDinggao(final DinggaoData data) {
        mTvTitle.setText("论文定稿");

        mBtLunwenChoose.setText("下载论文");
        mBtFujianChoose.setText("下载附件");
        final String[] urls = data.attachment.split(",");
        mTvLunwen.setText("论文");
        mBtLunwenChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(urls[0]));
                request.setDestinationInExternalPublicDir("/download/", "lunwen");
                DownloadManager downloadManager = (DownloadManager) DinggaoActivity.this.getSystemService(Context.DOWNLOAD_SERVICE);
                downloadManager.enqueue(request);
            }
        });
        if (urls.length > 1) {
            mTvFujian.setText("附件");
            mBtFujianChoose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(urls[1]));
                    request.setDestinationInExternalPublicDir("/download/", "lunwenfujian");
                    DownloadManager downloadManager = (DownloadManager) DinggaoActivity.this.getSystemService(Context.DOWNLOAD_SERVICE);
                    downloadManager.enqueue(request);
                }
            });
        } else {
            mTvFujian.setText("无附件");
            mBtFujianChoose.setBackgroundColor(Color.GRAY);
        }

        mBtTijiao.setVisibility(View.GONE);

    }

    @Override
    public void onNotIn(int status, String msg) {
        mScrollView.setVisibility(View.GONE);
        mTvTishi.setVisibility(View.VISIBLE);
    }

    @Override
    public void onPost(int status, String msg) {

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        if (status == 1) {
            finish();
        }
    }



}

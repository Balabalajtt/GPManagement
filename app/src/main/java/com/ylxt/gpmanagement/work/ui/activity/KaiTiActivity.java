package com.ylxt.gpmanagement.work.ui.activity;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.ylxt.gpmanagement.R;
import com.ylxt.gpmanagement.base.common.FileUtil;
import com.ylxt.gpmanagement.base.common.Info;
import com.ylxt.gpmanagement.base.ui.activity.BaseMvpActivity;
import com.ylxt.gpmanagement.work.data.gson.KaitiData;
import com.ylxt.gpmanagement.work.presenter.KaiTiPresenter;
import com.ylxt.gpmanagement.work.presenter.view.KaiTiView;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by 江婷婷 on 2018/5/15.
 */

public class KaiTiActivity extends BaseMvpActivity<KaiTiPresenter> implements KaiTiView, View.OnClickListener {

    private static final String TAG = "KaiTiActivity";

    private ImageView mImBack;
    private Button mBtTijiao;
    private Button mBtChoose;
    private TextView mTvWenjian;

    private String mFilePath = "";
    private File mFile = null;

    private EditText mEtPurpose;
    private EditText mEtBasis;
    private EditText mEtProblems;
    private EditText mEtPlan;
    private EditText mEtOpinion;

    private TextView mTvTitle;
    private TextView mTvOpinion;

    private ScrollView mScrollView;
    private TextView mTvTishi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kaiti);

        mPresenter = new KaiTiPresenter();
        mPresenter.mView = this;

        mScrollView = findViewById(R.id.scroll_view);
        mTvTishi = findViewById(R.id.tv_tishi);

        mImBack = findViewById(R.id.im_back);
        mBtTijiao = findViewById(R.id.bt_tijiao);
        mBtChoose = findViewById(R.id.bt_choose);
        mTvWenjian = findViewById(R.id.tv_wenjian);
        mImBack.setOnClickListener(this);
        mBtTijiao.setOnClickListener(this);
        mBtChoose.setOnClickListener(this);

        mTvTitle = findViewById(R.id.tv_title);
        mTvOpinion = findViewById(R.id.tv_opinion);
        mEtOpinion = findViewById(R.id.et_opinion);

        mEtPurpose = findViewById(R.id.et_purpose);
        mEtBasis = findViewById(R.id.et_basis);
        mEtProblems = findViewById(R.id.et_problems);
        mEtPlan = findViewById(R.id.et_plan);

        mPresenter.checkKaiti();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.im_back:
                finish();
                break;
            case R.id.bt_choose:
                openFileManager();
                break;
            case R.id.bt_tijiao:
                mPresenter.postKaiTi(mEtPurpose.getText().toString(), mEtBasis.getText().toString(), mEtProblems.getText().toString(), mEtPlan.getText().toString());
                break;
        }
    }

    private void openFileManager() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");//无类型限制
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            Uri uri = data.getData();
            mFilePath = FileUtil.getPathByUri(this, uri);
            Log.d(TAG, "onActivityResult: " + mFilePath + uri);
            if (mFilePath != null) {
                mFile = new File(mFilePath);
                Log.d(TAG, "onActivityResult: " + mFilePath);
                if (mFile.exists()) {
                    mTvWenjian.setText("文件选择成功：" + mFile.getName());
                    Log.d(TAG, "onActivityResult: " + mFilePath);
                    return;
                }
            }
            mTvWenjian.setText("文件选择失败");

        }
    }


    @Override
    public void onPostKaiti(int status, String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        if (status == 1) {
            if (mFile != null) {
                RequestBody requestFile = RequestBody
                        .create(MediaType.parse("*/*"), mFile);
                MultipartBody.Part body = MultipartBody.Part
                        .createFormData("file", mFile.getName(), requestFile);
                mPresenter.postKaiTFujian(body);
            } else {
                finish();
            }
        }
    }

    @Override
    public void onPostFujian(int status, String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        if (status == 1) {
            finish();
        }
    }

    @Override
    public void onTianxieKaiti(int status, String msg) {
    }

    @Override
    public void onShowKaiti(final KaitiData data) {
        mTvTitle.setText("开题报告");
//        mEtPurpose.setEnabled(false);
//        mEtBasis.setEnabled(false);
//        mEtProblems.setEnabled(false);
//        mEtPlan.setEnabled(false);
//        mEtOpinion.setEnabled(false);

        mEtPurpose.setFocusable(false);
        mEtBasis.setFocusable(false);
        mEtProblems.setFocusable(false);
        mEtPlan.setFocusable(false);
        mEtOpinion.setFocusable(false);

        mEtOpinion.setVisibility(View.VISIBLE);
        mTvOpinion.setVisibility(View.VISIBLE);

        mBtChoose.setText("下载附件");
        if (!TextUtils.isEmpty(data.attachment)) {
            mTvWenjian.setText("开题报告附件");
            mBtChoose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(data.attachment));
                    request.setDestinationInExternalPublicDir("/download/", "kaiti");
                    DownloadManager downloadManager = (DownloadManager) KaiTiActivity.this.getSystemService(Context.DOWNLOAD_SERVICE);
                    downloadManager.enqueue(request);
                }
            });
        } else {
            mTvWenjian.setText("无附件");
            mBtChoose.setBackgroundColor(Color.GRAY);
        }

        mBtTijiao.setVisibility(View.GONE);

        mEtPurpose.setText(data.purpose);
        mEtBasis.setText(data.basis);
        mEtProblems.setText(data.problems);
        mEtPlan.setText(data.plan);
        if (TextUtils.isEmpty(data.opinion)) {
            mEtOpinion.setText("未审核");
        } else {
            mEtOpinion.setText(data.opinion);
        }

    }

    @Override
    public void onNotIn(int status, String msg) {
        mScrollView.setVisibility(View.GONE);
        mTvTishi.setVisibility(View.VISIBLE);
    }
}

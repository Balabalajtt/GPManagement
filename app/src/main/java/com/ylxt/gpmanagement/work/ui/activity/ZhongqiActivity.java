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
import com.ylxt.gpmanagement.base.ui.activity.BaseMvpActivity;
import com.ylxt.gpmanagement.work.data.gson.ZhongqiData;
import com.ylxt.gpmanagement.work.presenter.ZhongqiPresenter;
import com.ylxt.gpmanagement.work.presenter.view.ZhongqiView;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class ZhongqiActivity extends BaseMvpActivity<ZhongqiPresenter> implements View.OnClickListener, ZhongqiView {


    private ImageView mImBack;
    private Button mBtTijiao;
    private Button mBtChoose;
    private TextView mTvWenjian;

    private String mFilePath = "";
    private File mFile = null;

    private TextView mEtArea;
    private TextView mEtConclusion;

    private TextView mTvTitle;

    private ScrollView mScrollView;
    private TextView mTvTishi;

    private static final String TAG = "ZhongqiActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhongqi);

        mPresenter = new ZhongqiPresenter();
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

        mEtArea = findViewById(R.id.et_area);
        mEtConclusion = findViewById(R.id.et_conclusion);

        mPresenter.checkZhongqi();

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
                mPresenter.postZhongqi(mEtArea.getText().toString(), mEtConclusion.getText().toString());
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
    public void onPostZhongqi(int status, String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        if (status == 1) {
            if (mFile != null) {
                RequestBody requestFile = RequestBody
                        .create(MediaType.parse("*/*"), mFile);
                MultipartBody.Part body = MultipartBody.Part
                        .createFormData("file", mFile.getName(), requestFile);
                mPresenter.postZhongqiFujian(body);
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
    public void onTianxieZhongqi(int status, String msg) {
    }

    @Override
    public void onShowZhongqi(final ZhongqiData data) {
        mTvTitle.setText("中期报告");

        mEtArea.setFocusable(false);
        mEtConclusion.setFocusable(false);

        mBtChoose.setText("下载附件");
        if (!TextUtils.isEmpty(data.attachment)) {
            mTvWenjian.setText("开题报告附件");
            mBtChoose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(data.attachment));
                    request.setDestinationInExternalPublicDir("/download/", "kaiti");
                    DownloadManager downloadManager = (DownloadManager) ZhongqiActivity.this.getSystemService(Context.DOWNLOAD_SERVICE);
                    downloadManager.enqueue(request);
                }
            });
        } else {
            mTvWenjian.setText("无附件");
            mBtChoose.setBackgroundColor(Color.GRAY);
        }

        mBtTijiao.setVisibility(View.GONE);

        mEtArea.setText(data.designArea);
        mEtConclusion.setText(data.midConclusion);

    }

    @Override
    public void onNotIn(int status, String msg) {
        mScrollView.setVisibility(View.GONE);
        mTvTishi.setVisibility(View.VISIBLE);
    }

}

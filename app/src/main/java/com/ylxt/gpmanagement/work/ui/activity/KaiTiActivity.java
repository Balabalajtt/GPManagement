package com.ylxt.gpmanagement.work.ui.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ylxt.gpmanagement.R;
import com.ylxt.gpmanagement.base.common.FileUtil;
import com.ylxt.gpmanagement.base.ui.activity.BaseMvpActivity;
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
    private Button mBtFujian;
    private Button mBtChoose;
    private TextView mTvWenjian;

    private String mFilePath = "";
    private File mFile = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kaiti);

        mPresenter = new KaiTiPresenter();
        mPresenter.mView = this;

        mImBack = findViewById(R.id.im_back);
        mBtTijiao = findViewById(R.id.bt_tijiao);
        mBtFujian = findViewById(R.id.bt_fujian);
        mBtChoose = findViewById(R.id.bt_choose);
        mTvWenjian = findViewById(R.id.tv_wenjian);
        mImBack.setOnClickListener(this);
        mBtTijiao.setOnClickListener(this);
        mBtFujian.setOnClickListener(this);
        mBtChoose.setOnClickListener(this);

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
            case R.id.bt_fujian:
                RequestBody requestFile = RequestBody
                        .create(MediaType.parse("*/*"), mFile);
                MultipartBody.Part body = MultipartBody.Part
                        .createFormData("file", mFile.getName(), requestFile);
                mPresenter.postKaiTFujian(body);
                break;
            case R.id.bt_tijiao:
                mPresenter.postKaiTi();
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
                    mBtFujian.setClickable(true);
                    return;
                }
            }
            mTvWenjian.setText("文件选择失败");
            mBtFujian.setClickable(true);

        }
    }


}

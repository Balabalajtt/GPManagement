package com.ylxt.gpmanagement.work.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ylxt.gpmanagement.R;
import com.ylxt.gpmanagement.base.common.FileUtil;
import com.ylxt.gpmanagement.base.ui.activity.BaseMvpActivity;
import com.ylxt.gpmanagement.work.presenter.ShengbaoPresenter;
import com.ylxt.gpmanagement.work.presenter.view.ShengbaoView;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class ShengbaoActivity extends BaseMvpActivity<ShengbaoPresenter> implements ShengbaoView, View.OnClickListener {

    private static final String TAG = "ShengbaoActivity";

    private ImageView mImBack;
    private EditText mEdSubjectName;
    private EditText mEdTopicSource;
    private EditText mEdSubjectType;
    private EditText mEdTopicType;
    private EditText mEdTopicPaper;
    private EditText mEdAbility;
    private EditText mEdTarget;
    private EditText mEdGuideTeacher;

    private Button mBtChoose;
    private TextView mTvWenjian;

    private Button mButton;

    private String mFilePath = "";
    private File mFile = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shengbao);

        mPresenter = new ShengbaoPresenter();
        mPresenter.mView = this;

        mImBack = findViewById(R.id.im_back);
        mImBack.setOnClickListener(this);

        mEdSubjectName = findViewById(R.id.et_subjectName);
        mEdTopicSource = findViewById(R.id.et_topicSource);
        mEdSubjectType = findViewById(R.id.et_subjectType);
        mEdTopicType = findViewById(R.id.et_topicType);
        mEdTopicPaper = findViewById(R.id.et_topicPaper);
        mEdAbility = findViewById(R.id.et_ability);
        mEdTarget = findViewById(R.id.et_target);
        mEdGuideTeacher = findViewById(R.id.et_guideTeacher);

        mBtChoose = findViewById(R.id.bt_choose);
        mTvWenjian = findViewById(R.id.tv_wenjian);

        mButton = findViewById(R.id.bt_tijiao);

        mBtChoose.setOnClickListener(this);
        mButton.setOnClickListener(this);

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
                break;
            case R.id.bt_tijiao:
                mPresenter.postShengbao(
                        mEdSubjectName.getText().toString(),
                        mEdTopicSource.getText().toString(),
                        mEdSubjectType.getText().toString(),
                        mEdTopicType.getText().toString(),
                        mEdTopicPaper.getText().toString(),
                        mEdAbility.getText().toString(),
                        mEdTarget.getText().toString(),
                        mEdGuideTeacher.getText().toString());

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
    public void onPostShengbao(int status, String msg) {
        if (status == 1) {

            RequestBody requestFile = RequestBody
                    .create(MediaType.parse("*/*"), mFile);
            MultipartBody.Part body = MultipartBody.Part
                    .createFormData("file", mFile.getName(), requestFile);
            mPresenter.postFujian(body);

        }
        Toast.makeText(ShengbaoActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPostFujian(int status, String msg) {

        if (status == 1) {
            startActivity(new Intent(ShengbaoActivity.this, MainActivity.class));
            finish();
        }
        Toast.makeText(ShengbaoActivity.this, msg, Toast.LENGTH_SHORT).show();
    }
}

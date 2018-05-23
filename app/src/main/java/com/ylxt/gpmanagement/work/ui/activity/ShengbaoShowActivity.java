package com.ylxt.gpmanagement.work.ui.activity;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ylxt.gpmanagement.R;
import com.ylxt.gpmanagement.base.common.Info;
import com.ylxt.gpmanagement.base.ui.activity.BaseActivity;

public class ShengbaoShowActivity extends BaseActivity implements View.OnClickListener {

    private ImageView mImBack;
    private Button mFujian;
    private TextView mTvSubjectName;
    private TextView mTvTopicSource;
    private TextView mTvSubjectType;
    private TextView mTvTopicType;
    private TextView mTvTopicPaper;
    private TextView mTvAbility;
    private TextView mTvTarget;
    private TextView mTvGuideTeacher;
    private TextView mTvFileName;

    private static final String TAG = "ShengbaoShowActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shengbao_show);

        mTvSubjectName = findViewById(R.id.et_subjectName);
        mTvTopicSource = findViewById(R.id.et_topicSource);
        mTvSubjectType = findViewById(R.id.et_subjectType);
        mTvTopicType = findViewById(R.id.et_topicType);
        mTvTopicPaper = findViewById(R.id.et_topicPaper);
        mTvAbility = findViewById(R.id.et_ability);
        mTvTarget = findViewById(R.id.et_target);
        mTvGuideTeacher = findViewById(R.id.et_guideTeacher);
        mTvFileName = findViewById(R.id.tv_wenjian);
        mFujian = findViewById(R.id.bt_fujian);
        mImBack = findViewById(R.id.im_back);

        mImBack.setOnClickListener(this);
        mTvSubjectName.setText(Info.mShengbaoData.subjectName);
        mTvTopicSource.setText(Info.mShengbaoData.topicSource);
        mTvSubjectType.setText(Info.mShengbaoData.subjectType);
        mTvTopicType.setText(Info.mShengbaoData.topicType);
        mTvTopicPaper.setText(Info.mShengbaoData.topicPaper);
        mTvAbility.setText(Info.mShengbaoData.ability);
        mTvTarget.setText(Info.mShengbaoData.target);
        mTvGuideTeacher.setText(Info.mShengbaoData.guideTeacher);
        Log.d(TAG, "onCreate: " + Info.mShengbaoData.attachment);

        if (TextUtils.isEmpty(Info.mShengbaoData.attachment) || Info.mShengbaoData.attachment.equals("null")) {
            mTvFileName.setText("无附件");
            mFujian.setClickable(false);
        } else {
            mFujian.setOnClickListener(this);
        }

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.im_back:
                finish();
                break;
            case R.id.bt_fujian:
                Log.d(TAG, "onClick: " + Info.mShengbaoData.attachment);
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(Info.mShengbaoData.attachment/*"http://120.79.196.225:8080/GPManagement/DECLARE_SUBJECT_PATH/04163216/07f8eba28cf04f94b66759cdca5faeac.jpg"*/));
                request.setDestinationInExternalPublicDir("/download/", "shengbao");
                DownloadManager downloadManager= (DownloadManager) this.getSystemService(Context.DOWNLOAD_SERVICE);
                downloadManager.enqueue(request);
                break;
        }
    }
}

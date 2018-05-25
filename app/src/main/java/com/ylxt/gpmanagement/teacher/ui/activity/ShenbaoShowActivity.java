package com.ylxt.gpmanagement.teacher.ui.activity;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ylxt.gpmanagement.R;
import com.ylxt.gpmanagement.base.common.Info;
import com.ylxt.gpmanagement.base.presenter.BasePresenter;
import com.ylxt.gpmanagement.base.ui.activity.BaseMvpActivity;
import com.ylxt.gpmanagement.teacher.presenter.ShenbaoShowPresenter;
import com.ylxt.gpmanagement.teacher.presenter.view.ShenbaoShowView;

public class ShenbaoShowActivity extends BaseMvpActivity<ShenbaoShowPresenter> implements ShenbaoShowView {

    private ImageView mImBack;
    private Button mFujian;
    private TextView mTvSubjectName;
    private TextView mTvTopicSource;
    private TextView mTvSubjectType;
    private TextView mTvTopicType;
    private TextView mTvTopicPaper;
    private TextView mTvAbility;
    private TextView mTvTarget;
    private TextView mTvFileName;
    private Button mBtYes;
    private Button mBtNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shenbao_show);
        mPresenter = new ShenbaoShowPresenter();
        mPresenter.mView = this;

//        SubjectData data = getIntent().getParcelableExtra("shenbao");

        mTvSubjectName = findViewById(R.id.et_subjectName);
        mTvTopicSource = findViewById(R.id.et_topicSource);
        mTvSubjectType = findViewById(R.id.et_subjectType);
        mTvTopicType = findViewById(R.id.et_topicType);
        mTvTopicPaper = findViewById(R.id.et_topicPaper);
        mTvAbility = findViewById(R.id.et_ability);
        mTvTarget = findViewById(R.id.et_target);
        mTvFileName = findViewById(R.id.tv_wenjian);
        mFujian = findViewById(R.id.bt_fujian);
        mImBack = findViewById(R.id.im_back);
        mBtYes = findViewById(R.id.bt_yes);
        mBtNo = findViewById(R.id.bt_no);

        mImBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mTvSubjectName.setText(Info.mSubjectData.subjectName);
        mTvTopicSource.setText(Info.mSubjectData.topicSource);
        mTvSubjectType.setText(Info.mSubjectData.subjectType);
        mTvTopicType.setText(Info.mSubjectData.topicType);
        mTvTopicPaper.setText(Info.mSubjectData.topicPaper);
        mTvAbility.setText(Info.mSubjectData.ability);
        mTvTarget.setText(Info.mSubjectData.target);
        if (TextUtils.isEmpty(Info.mSubjectData.attachment) || Info.mSubjectData.attachment.equals("null")) {
            mTvFileName.setText("无附件");
            mFujian.setClickable(false);
        } else {
            mFujian.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(Info.mSubjectData.attachment/*"http://120.79.196.225:8080/GPManagement/DECLARE_SUBJECT_PATH/04163216/07f8eba28cf04f94b66759cdca5faeac.jpg"*/));
                    request.setDestinationInExternalPublicDir("/download/", "shengbao");
                    DownloadManager downloadManager= (DownloadManager) ShenbaoShowActivity.this.getSystemService(Context.DOWNLOAD_SERVICE);
                    downloadManager.enqueue(request);
                }
            });
        }

        mBtYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.dealShenbao(Info.mSubjectData.id, 1);
            }
        });

        mBtNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.dealShenbao(Info.mSubjectData.id, -1);
            }
        });



    }

    @Override
    public void onDealShenbao(int status, String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        if (status == 1) {
            finish();
        }
    }
}

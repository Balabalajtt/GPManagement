package com.ylxt.gpmanagement.teacher.ui.activity;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.ylxt.gpmanagement.R;
import com.ylxt.gpmanagement.base.common.Info;
import com.ylxt.gpmanagement.base.ui.activity.BaseMvpActivity;
import com.ylxt.gpmanagement.teacher.presenter.KaitiShowPresenter;
import com.ylxt.gpmanagement.teacher.presenter.view.KaitiShowView;
import com.ylxt.gpmanagement.work.ui.activity.KaiTiActivity;

import java.io.File;

public class KaitiShowActivity extends BaseMvpActivity<KaitiShowPresenter> implements KaitiShowView {



    private ImageView mImBack;
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

    private Button mBtYes;
    private Button mBtNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kaiti_show);

        mPresenter = new KaitiShowPresenter();
        mPresenter.mView = this;

        mImBack = findViewById(R.id.im_back);
        mBtChoose = findViewById(R.id.bt_choose);
        mBtYes = findViewById(R.id.bt_yes);
        mBtNo = findViewById(R.id.bt_no);
        mTvWenjian = findViewById(R.id.tv_wenjian);
        mImBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mBtChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(Info.mKaitiData.attachment));
                request.setDestinationInExternalPublicDir("/download/", "kaiti");
                DownloadManager downloadManager = (DownloadManager) KaitiShowActivity.this.getSystemService(Context.DOWNLOAD_SERVICE);
                downloadManager.enqueue(request);
            }
        });

        mTvTitle = findViewById(R.id.tv_title);
        mTvOpinion = findViewById(R.id.tv_opinion);
        mEtOpinion = findViewById(R.id.et_opinion);

        mEtPurpose = findViewById(R.id.et_purpose);
        mEtBasis = findViewById(R.id.et_basis);
        mEtProblems = findViewById(R.id.et_problems);
        mEtPlan = findViewById(R.id.et_plan);

        mEtPurpose.setFocusable(false);
        mEtBasis.setFocusable(false);
        mEtProblems.setFocusable(false);
        mEtPlan.setFocusable(false);
        mEtPurpose.setText(Info.mKaitiData.purpose);
        mEtBasis.setText(Info.mKaitiData.basis);
        mEtProblems.setText(Info.mKaitiData.problems);
        mEtPlan.setText(Info.mKaitiData.plan);

        mImBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mBtYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.dealKaiti(Info.mKaitiData.id, 1, mEtOpinion.getText().toString());
            }
        });

        mBtNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.dealKaiti(Info.mKaitiData.id, -1, mEtOpinion.getText().toString());
            }
        });

    }

    @Override
    public void onDealKaiti(int status, String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        if (status == 1) {
            finish();
        }
    }
}

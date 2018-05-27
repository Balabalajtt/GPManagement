package com.ylxt.gpmanagement.teacher.ui.activity;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ylxt.gpmanagement.R;
import com.ylxt.gpmanagement.base.common.Info;
import com.ylxt.gpmanagement.base.ui.activity.BaseMvpActivity;
import com.ylxt.gpmanagement.teacher.presenter.ZhongqiShowPresenter;
import com.ylxt.gpmanagement.teacher.presenter.view.ZhongqiShowView;

public class ZhongqiShowActivity extends BaseMvpActivity<ZhongqiShowPresenter> implements ZhongqiShowView {

    private ImageView mImBack;
    private Button mFujian;
    private TextView mTvArea;
    private TextView mTvConclusion;
    private TextView mTvFileName;
    private Button mBtYes;
    private Button mBtNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhongqi_show);

        mPresenter = new ZhongqiShowPresenter();
        mPresenter.mView = this;

        mTvConclusion = findViewById(R.id.et_conclusion);
        mTvArea = findViewById(R.id.et_area);
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
        mTvArea.setText(Info.mZhongqiData.designArea);
        mTvConclusion.setText(Info.mZhongqiData.midConclusion);
        if (TextUtils.isEmpty(Info.mZhongqiData.attachment) || Info.mZhongqiData.attachment.equals("null")) {
            mTvFileName.setText("无附件");
            mFujian.setClickable(false);
        } else {
            mFujian.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(Info.mZhongqiData.attachment));
                    request.setDestinationInExternalPublicDir("/download/", "shengbao");
                    DownloadManager downloadManager= (DownloadManager) ZhongqiShowActivity.this.getSystemService(Context.DOWNLOAD_SERVICE);
                    downloadManager.enqueue(request);
                }
            });
        }

        mBtYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.dealZhongqi(Info.mZhongqiData.id, 1);
            }
        });

        mBtNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.dealZhongqi(Info.mZhongqiData.id, -1);
            }
        });



    }

    @Override
    public void onDealZhongqi(int status, String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        if (status == 1) {
            finish();
        }
    }
}

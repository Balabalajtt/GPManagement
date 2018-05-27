package com.ylxt.gpmanagement.teacher.ui.activity;

import android.app.DownloadManager;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ylxt.gpmanagement.R;
import com.ylxt.gpmanagement.base.common.Info;
import com.ylxt.gpmanagement.base.ui.activity.BaseMvpActivity;
import com.ylxt.gpmanagement.teacher.presenter.DinggaoShowPresenter;
import com.ylxt.gpmanagement.teacher.presenter.view.DinggaoShowView;

public class DinggaoShowActivity extends BaseMvpActivity<DinggaoShowPresenter> implements DinggaoShowView {

    private ImageView mImBack;

    private Button mBtTijiao;
    private Button mBtLunwenChoose;
    private Button mBtFujianChoose;
    private TextView mTvLunwen;
    private TextView mTvFujian;
    private EditText mEdScore;
    private EditText mEdMessage;

    private Button mBtYes;
    private Button mBtNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinggao_show);

        mPresenter = new DinggaoShowPresenter();
        mPresenter.mView = this;

        mBtLunwenChoose = findViewById(R.id.bt_lunwen);
        mTvLunwen = findViewById(R.id.tv_lunwen);
        mBtFujianChoose = findViewById(R.id.bt_fujian);
        mTvFujian = findViewById(R.id.tv_fujian);
        mEdScore = findViewById(R.id.et_score);
        mEdMessage = findViewById(R.id.et_message);

        final String[] urls = Info.mDinggaoData.attachment.split(",");
        mTvLunwen.setText("论文");
        mBtLunwenChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(urls[0]));
                request.setDestinationInExternalPublicDir("/download/", "lunwen");
                DownloadManager downloadManager = (DownloadManager) DinggaoShowActivity.this.getSystemService(Context.DOWNLOAD_SERVICE);
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
                    DownloadManager downloadManager = (DownloadManager) DinggaoShowActivity.this.getSystemService(Context.DOWNLOAD_SERVICE);
                    downloadManager.enqueue(request);
                }
            });
        } else {
            mTvFujian.setText("无附件");
            mBtFujianChoose.setBackgroundColor(Color.GRAY);
        }

        mImBack = findViewById(R.id.im_back);
        mBtYes = findViewById(R.id.bt_yes);
        mBtNo = findViewById(R.id.bt_no);

        mImBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mBtYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mPresenter.dealDinggao(Info.mDinggaoData.id, 1, Integer.parseInt(mEdScore.getText().toString()), mEdMessage.getText().toString());
            }
        });

        mBtNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.dealDinggao(Info.mDinggaoData.id, -1, Integer.parseInt(mEdScore.getText().toString()), mEdMessage.getText().toString());
            }
        });



    }

    @Override
    public void onDealDinggao(int status, String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        if (status == 1) {
            finish();
        }
    }
}

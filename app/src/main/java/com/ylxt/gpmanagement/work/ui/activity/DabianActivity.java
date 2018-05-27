package com.ylxt.gpmanagement.work.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ylxt.gpmanagement.R;
import com.ylxt.gpmanagement.base.net.RetrofitFactory;
import com.ylxt.gpmanagement.base.rx.BaseSubscriber;
import com.ylxt.gpmanagement.work.data.api.SubjectApi;
import com.ylxt.gpmanagement.work.data.gson.Dinggao;
import com.ylxt.gpmanagement.work.data.gson.DinggaoData;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DabianActivity extends AppCompatActivity {

    private ImageView mImBack;
    private TextView mTvName;
    private TextView mTvNum;
    private TextView mTvSubjectName;
    private TextView mTvScore;
    private TextView mTvMessage;
    private LinearLayout ll;
    private TextView tvTishi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dabian);

        mImBack = findViewById(R.id.im_back);
        mImBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mTvName = findViewById(R.id.tv_name);
        mTvNum = findViewById(R.id.tv_num);
        mTvSubjectName = findViewById(R.id.tv_subject_name);
        mTvScore = findViewById(R.id.tv_score);
        mTvMessage = findViewById(R.id.tv_message);
        ll = findViewById(R.id.ll);
        tvTishi = findViewById(R.id.tv_tishi);

        RetrofitFactory.INSTANCE.create(SubjectApi.class).checkDabian()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new BaseSubscriber<Dinggao>() {
                    @Override
                    public void onNext(Dinggao dinggao) {
                        super.onNext(dinggao);
                        if (dinggao.status == 1) {
                            showDabian(dinggao.data);
                        } else {
                            notIn(dinggao.msg);
                        }

                    }
                });

    }

    private void notIn(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        ll.setVisibility(View.GONE);
        tvTishi.setVisibility(View.VISIBLE);
    }

    private static final String TAG = "DabianActivity";
    private void showDabian(DinggaoData data) {
        mTvName.setText(data.studentName);
        mTvNum.setText(data.number);
        mTvSubjectName.setText(data.subjectName);
        Log.d(TAG, "showDabian: " + data.score);
        mTvScore.setText(data.score + "");
        mTvMessage.setText(data.message + "");
    }
}

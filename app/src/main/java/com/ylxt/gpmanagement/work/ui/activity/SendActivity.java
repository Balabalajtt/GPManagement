package com.ylxt.gpmanagement.work.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ylxt.gpmanagement.R;
import com.ylxt.gpmanagement.base.ui.activity.BaseMvpActivity;
import com.ylxt.gpmanagement.work.presenter.SendPresenter;
import com.ylxt.gpmanagement.work.presenter.view.SendView;

public class SendActivity extends BaseMvpActivity<SendPresenter> implements SendView {

    private TextView mTvSend;
    private EditText mEtPeople;
    private EditText mEtContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);

        mPresenter = new SendPresenter();
        mPresenter.mView = this;

        mTvSend = findViewById(R.id.tv_send);
        mEtPeople = findViewById(R.id.et_people);
        mEtContent = findViewById(R.id.et_content);

        mTvSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.sendMessage(mEtPeople.getText().toString(), mEtContent.getText().toString());
            }
        });

    }

    @Override
    public void onSendSucc(int status, String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onSendFail(int status, String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        finish();
    }
}

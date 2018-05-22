package com.ylxt.gpmanagement.work.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ylxt.gpmanagement.R;
import com.ylxt.gpmanagement.base.common.Constant;
import com.ylxt.gpmanagement.base.ui.activity.BaseMvpActivity;
import com.ylxt.gpmanagement.work.presenter.LoginPresenter;
import com.ylxt.gpmanagement.work.presenter.view.LoginView;

public class LogActivity extends BaseMvpActivity<LoginPresenter> implements LoginView, View.OnClickListener {

    private ImageView mImBack;
    private TextView mTitle;

    private EditText mEtNum;
    private EditText mEditPwd;
    private Button mBtLogin;

    private static final String TAG = "LogActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);


        Constant.context = this;

        mPresenter = new LoginPresenter();
        mPresenter.mView = this;

        initView();
    }

    private void initView() {
        mImBack = findViewById(R.id.im_back);
        mBtLogin = findViewById(R.id.bt_login);
        mImBack.setOnClickListener(this);
        mBtLogin.setOnClickListener(this);

        mTitle = findViewById(R.id.tv_title);
        mEtNum = findViewById(R.id.et_num);
        mEditPwd = findViewById(R.id.et_pwd);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.im_back:
                break;
            case R.id.bt_login:
                mPresenter.login(mEtNum.getText().toString(), mEditPwd.getText().toString());
                break;
        }
    }

    @Override
    public void onLoginFail(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginSucc(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
        startActivity(new Intent(LogActivity.this, MainActivity.class));
        finish();
    }
}

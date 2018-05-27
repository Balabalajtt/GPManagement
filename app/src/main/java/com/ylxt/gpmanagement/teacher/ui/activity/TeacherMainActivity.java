package com.ylxt.gpmanagement.teacher.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ylxt.gpmanagement.R;
import com.ylxt.gpmanagement.base.ui.activity.BaseMvpActivity;
import com.ylxt.gpmanagement.teacher.presenter.TeacherPresenter;
import com.ylxt.gpmanagement.teacher.presenter.view.TeacherView;
import com.ylxt.gpmanagement.work.ui.activity.LogActivity;
import com.ylxt.gpmanagement.work.ui.activity.ShouXinActivity;

public class TeacherMainActivity extends BaseMvpActivity<TeacherPresenter> implements TeacherView, View.OnClickListener {

    private Button mBtFabu;
    private Button mBtShenbao;
//    private Button mBtSubjects;
    private Button mBtFaxin;
    private Button mBtShouxin;
    private Button mBtKaiti;
    private Button mBtZhongqi;
    private Button mBtDinggao;
    private Button mBtLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_main);

        mPresenter = new TeacherPresenter();
        mPresenter.mView = this;

        mBtFabu = findViewById(R.id.bt_fabu);
        mBtFabu.setOnClickListener(this);
        mBtShenbao = findViewById(R.id.bt_shenbao);
        mBtShenbao.setOnClickListener(this);
//        mBtSubjects = findViewById(R.id.bt_my_subjects);
//        mBtSubjects.setOnClickListener(this);
        mBtFaxin = findViewById(R.id.bt_faxin);
        mBtFaxin.setOnClickListener(this);
        mBtShouxin = findViewById(R.id.bt_shouxin);
        mBtShouxin.setOnClickListener(this);
        mBtKaiti = findViewById(R.id.bt_deal_kaiti);
        mBtKaiti.setOnClickListener(this);
        mBtZhongqi = findViewById(R.id.bt_deal_zhongqi);
        mBtZhongqi.setOnClickListener(this);
        mBtDinggao = findViewById(R.id.bt_deal_dinggao);
        mBtDinggao.setOnClickListener(this);
        mBtLogout = findViewById(R.id.bt_logout);
        mBtLogout.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_shenbao:
                startActivity(new Intent(TeacherMainActivity.this, TeacherShenbaoActivity.class));
                break;
            case R.id.bt_fabu:
                startActivity(new Intent(TeacherMainActivity.this, TeacherAddSubjectActivity.class));
                break;
//            case R.id.bt_my_subjects:
//
//                break;
            case R.id.bt_faxin:
                Intent intent = new Intent(TeacherMainActivity.this, ShouXinActivity.class);
                intent.putExtra("type", 1);
                startActivity(intent);
                break;
            case R.id.bt_shouxin:
                intent = new Intent(TeacherMainActivity.this, ShouXinActivity.class);
                intent.putExtra("type", 0);
                startActivity(intent);
                break;
            case R.id.bt_deal_kaiti:
                startActivity(new Intent(TeacherMainActivity.this, TeacherKaitiActivity.class));
                break;
            case R.id.bt_deal_zhongqi:
                startActivity(new Intent(TeacherMainActivity.this, TeacherZhongqiActivity.class));
                break;
            case R.id.bt_deal_dinggao:
                startActivity(new Intent(TeacherMainActivity.this, TeacherDinggaoActivity.class));
                break;
            case R.id.bt_logout:
                startActivity(new Intent(TeacherMainActivity.this, LogActivity.class));
                finish();
                break;
        }
    }


}

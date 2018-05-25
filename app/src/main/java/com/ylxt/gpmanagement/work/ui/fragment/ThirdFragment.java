package com.ylxt.gpmanagement.work.ui.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseExpandableListAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ylxt.gpmanagement.R;
import com.ylxt.gpmanagement.base.common.Info;
import com.ylxt.gpmanagement.base.ui.fragment.BaseFragment;
import com.ylxt.gpmanagement.base.ui.fragment.BaseMvpFragment;
import com.ylxt.gpmanagement.work.data.gson.Teacher;
import com.ylxt.gpmanagement.work.data.gson.UserData;
import com.ylxt.gpmanagement.work.presenter.ThirdPresenter;
import com.ylxt.gpmanagement.work.presenter.view.ThirdView;
import com.ylxt.gpmanagement.work.ui.activity.RizhiActivity;
import com.ylxt.gpmanagement.work.ui.activity.ShouXinActivity;

/**
 * Created by 江婷婷 on 2018/5/10.
 */

public class ThirdFragment extends BaseMvpFragment<ThirdPresenter> implements ThirdView, View.OnClickListener {

    private LinearLayout llConnect;
    private LinearLayout llShouxin;
    private LinearLayout llFaxin;
    private LinearLayout llZhidao;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, container, false);

        mPresenter = new ThirdPresenter();
        mPresenter.mView = this;

        llConnect = view.findViewById(R.id.ll_connect);
        llShouxin = view.findViewById(R.id.ll_shouxin);
        llFaxin = view.findViewById(R.id.ll_faxin);
        llZhidao = view.findViewById(R.id.ll_zhidao);
        llConnect.setOnClickListener(this);
        llShouxin.setOnClickListener(this);
        llFaxin.setOnClickListener(this);
        llZhidao.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_connect:
                mPresenter.getTeacherInfo();
                break;
            case R.id.ll_faxin:
                Intent intent = new Intent(getActivity(), ShouXinActivity.class);
                intent.putExtra("type", 1);
                startActivity(intent);
                break;
            case R.id.ll_shouxin:
                intent = new Intent(getActivity(), ShouXinActivity.class);
                intent.putExtra("type", 0);
                startActivity(intent);
                break;
            case R.id.ll_zhidao:
                startActivity(new Intent(getActivity(), RizhiActivity.class));
                break;
        }
    }

    private Dialog connectDialog(String name, String phone, String email) {
        final Dialog dialog = new Dialog(getContext(), R.style.NormalDialogStyle);

        View view = View.inflate(getContext(), R.layout.dialog_connect, null);

        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(true);
        //设置对话框的大小
        view.setMinimumHeight(500);
        view.setMinimumWidth(800);
        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = 800;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.CENTER;
        dialogWindow.setAttributes(lp);

        TextView tvTeacher = view.findViewById(R.id.tv_teacher);
        TextView tvPhone = view.findViewById(R.id.tv_phone);
        TextView tvEmail = view.findViewById(R.id.tv_email);
        tvTeacher.setText(name);
        tvPhone.setText(phone);
        tvEmail.setText(email);

        return dialog;
    }

    @Override
    public void onTeacherInfoSucc(UserData data) {
        connectDialog(data.username, data.phone, data.email).show();
    }

    @Override
    public void onTeacherInfoFail(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }
}

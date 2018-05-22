package com.ylxt.gpmanagement.work.ui.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ylxt.gpmanagement.R;
import com.ylxt.gpmanagement.base.common.Info;
import com.ylxt.gpmanagement.base.ui.fragment.BaseMvpFragment;
import com.ylxt.gpmanagement.work.presenter.MinePresenter;
import com.ylxt.gpmanagement.work.presenter.view.MineView;
import com.ylxt.gpmanagement.work.ui.activity.LogActivity;

/**
 * Created by 江婷婷 on 2018/5/10.
 */

public class ForthFragment extends BaseMvpFragment<MinePresenter> implements MineView, View.OnClickListener{

    public Dialog mChangePwdDialog;
    public Dialog mChangeInfoDialog;
    public Dialog mFankuiDialog;
    public Dialog mHelperDialog;
    public Dialog mMyInfoDialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mPresenter = new MinePresenter();
        mPresenter.mView = this;

        View view = inflater.inflate(R.layout.fragment_four, container, false);

        TextView tvName = view.findViewById(R.id.tv_name);
        tvName.setText(Info.userName/*"依里夏提"*/);
        TextView tvType = view.findViewById(R.id.tv_type);
        tvType.setText(Info.type == 1 ? "老师  " + Info.num : "学生  " + Info.num/*"03141013"*/);

        Button btLogout = view.findViewById(R.id.bt_logout);
        btLogout.setOnClickListener(this);

        LinearLayout llChangePwd = view.findViewById(R.id.ll_change_pwd);
        llChangePwd.setOnClickListener(this);
        LinearLayout llChangeInfo = view.findViewById(R.id.ll_change_info);
        llChangeInfo.setOnClickListener(this);
        LinearLayout llFankui = view.findViewById(R.id.ll_fankui);
        llFankui.setOnClickListener(this);
        LinearLayout llMyInfo = view.findViewById(R.id.ll_my_info);
        llMyInfo.setOnClickListener(this);
        LinearLayout llHelper = view.findViewById(R.id.ll_helper);
        llHelper.setOnClickListener(this);

        mChangePwdDialog = changePwdDialog();
        mChangeInfoDialog = changeInfoDialog();
        mFankuiDialog = textDialog("请联系我：13289227921");
        mHelperDialog = textDialog("毕设管理系统\n毕设管理系统\n毕设管理系统\n毕设管理系统");
        mMyInfoDialog = textDialog( Info.userName + "\n\n" + Info.num + "\n\n" + Info.phone + "\n\n" + Info.email);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_logout:
                mPresenter.logout();
                break;
            case R.id.ll_change_pwd:
                mChangePwdDialog.show();
                break;
            case R.id.ll_change_info:
                mChangeInfoDialog.show();
                break;
            case R.id.ll_fankui:
                mFankuiDialog.show();
                break;
            case R.id.ll_my_info:
                mMyInfoDialog.show();
                break;
            case R.id.ll_helper:
                mHelperDialog.show();
                break;
        }
    }

    private Dialog changePwdDialog() {
        final Dialog dialog = new Dialog(getContext(), R.style.NormalDialogStyle);

        View view = View.inflate(getContext(), R.layout.dialog_change_pwd, null);

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

        final EditText pwd = view.findViewById(R.id.et_pwd);
        final EditText confirmPwd = view.findViewById(R.id.et_confire_pwd);
        Button change = view.findViewById(R.id.bt_change);

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pwd1 = pwd.getText().toString();
                String pwd2 = confirmPwd.getText().toString();
                if (!pwd1.equals(pwd2)) {
                    Toast.makeText(getContext(), "两次密码不一致", Toast.LENGTH_SHORT).show();
                } else {
                    mPresenter.changePwd(pwd1);
                }
            }
        });
        return dialog;
    }

    private Dialog changeInfoDialog() {
        final Dialog dialog = new Dialog(getContext(), R.style.NormalDialogStyle);

        View view = View.inflate(getContext(), R.layout.dialog_change_info, null);

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

        final EditText phone = view.findViewById(R.id.et_phone);
        final EditText email = view.findViewById(R.id.et_email);
        phone.setText(Info.phone);
        email.setText(Info.email);
        Button change = view.findViewById(R.id.bt_change);

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneS = phone.getText().toString();
                String emailS = email.getText().toString();
                if (TextUtils.isEmpty(phoneS) || TextUtils.isEmpty(emailS)) {
                    Toast.makeText(getContext(), "信息不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    mPresenter.changeInfo(phoneS, emailS);
                }
            }
        });
        return dialog;
    }

    private Dialog textDialog(String content) {
        final Dialog dialog = new Dialog(getContext(), R.style.NormalDialogStyle);

        View view = View.inflate(getContext(), R.layout.dialog_fankui, null);

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

        TextView tvContent = view.findViewById(R.id.tv_content);
        tvContent.setText(content);

        return dialog;
    }

    @Override
    public void onChangePwd(int status, String msg) {
        if (status == 1) {
            mChangePwdDialog.dismiss();
        }
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onLogout() {
        startActivity(new Intent(getActivity(), LogActivity.class));
        getActivity().finish();
    }

    @Override
    public void onChangeInfo(int status, String msg) {
        if (status == 1) {
            mChangeInfoDialog.dismiss();
        }
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }
}

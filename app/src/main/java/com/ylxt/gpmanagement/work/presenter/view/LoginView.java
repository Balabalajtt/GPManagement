package com.ylxt.gpmanagement.work.presenter.view;

import com.ylxt.gpmanagement.base.presenter.view.BaseView;

/**
 * Created by 江婷婷 on 2018/5/15.
 */

public interface LoginView extends BaseView {
    void onLoginFail(String msg);
    void onLoginSucc(String msg);

    void onLoginTeacherSucc(String msg);
}

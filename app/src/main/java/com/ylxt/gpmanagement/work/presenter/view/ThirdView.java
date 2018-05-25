package com.ylxt.gpmanagement.work.presenter.view;

import com.ylxt.gpmanagement.base.presenter.view.BaseView;
import com.ylxt.gpmanagement.work.data.gson.Teacher;
import com.ylxt.gpmanagement.work.data.gson.UserData;

/**
 * Created by 江婷婷 on 2018/5/24.
 */

public interface ThirdView extends BaseView {
    void onTeacherInfoSucc(UserData data);

    void onTeacherInfoFail(String msg);
}

package com.ylxt.gpmanagement.work.presenter.view;

import com.ylxt.gpmanagement.base.presenter.view.BaseView;

/**
 * Created by 江婷婷 on 2018/5/21.
 */

public interface MineView extends BaseView {
    void onChangePwd(int status, String msg);
    void onLogout();

    void onChangeInfo(int status, String msg);
}

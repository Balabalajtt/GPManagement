package com.ylxt.gpmanagement.work.presenter.view;

import com.ylxt.gpmanagement.base.presenter.view.BaseView;

/**
 * Created by 江婷婷 on 2018/5/24.
 */

public interface SendView extends BaseView {
    void onSendSucc(int status, String msg);

    void onSendFail(int status, String msg);
}

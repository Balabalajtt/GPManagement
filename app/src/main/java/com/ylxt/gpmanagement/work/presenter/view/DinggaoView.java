package com.ylxt.gpmanagement.work.presenter.view;

import com.ylxt.gpmanagement.base.presenter.view.BaseView;
import com.ylxt.gpmanagement.work.data.gson.DinggaoData;
import com.ylxt.gpmanagement.work.data.gson.ZhongqiData;

/**
 * Created by 江婷婷 on 2018/5/20.
 */

public interface DinggaoView extends BaseView {
    void onTianDinggao(int status, String msg);

    void onShowDinggao(DinggaoData data);

    void onNotIn(int status, String msg);

    void onPost(int status, String msg);
}

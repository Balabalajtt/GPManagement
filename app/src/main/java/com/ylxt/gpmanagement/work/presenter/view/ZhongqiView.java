package com.ylxt.gpmanagement.work.presenter.view;

import com.ylxt.gpmanagement.base.presenter.view.BaseView;
import com.ylxt.gpmanagement.work.data.gson.KaitiData;
import com.ylxt.gpmanagement.work.data.gson.Zhongqi;
import com.ylxt.gpmanagement.work.data.gson.ZhongqiData;

/**
 * Created by 江婷婷 on 2018/5/20.
 */

public interface ZhongqiView extends BaseView {

    void onPostZhongqi(int status, String msg);

    void onPostFujian(int status, String msg);

    void onTianxieZhongqi(int status, String msg);

    void onShowZhongqi(ZhongqiData data);

    void onNotIn(int status, String msg);
}

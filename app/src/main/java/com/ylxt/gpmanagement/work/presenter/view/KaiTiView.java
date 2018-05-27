package com.ylxt.gpmanagement.work.presenter.view;

import com.ylxt.gpmanagement.base.presenter.view.BaseView;
import com.ylxt.gpmanagement.work.data.gson.KaitiData;

/**
 * Created by 江婷婷 on 2018/5/20.
 */

public interface KaiTiView extends BaseView {

    void onPostKaiti(int status, String msg);

    void onPostFujian(int status, String msg);

    void onTianxieKaiti(int status, String msg);

    void onShowKaiti(KaitiData data);

    void onNotIn(int status, String msg);
}

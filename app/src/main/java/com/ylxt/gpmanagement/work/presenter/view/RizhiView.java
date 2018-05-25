package com.ylxt.gpmanagement.work.presenter.view;

import com.ylxt.gpmanagement.base.presenter.view.BaseView;
import com.ylxt.gpmanagement.work.data.gson.RizhiData;

import java.util.List;

/**
 * Created by 江婷婷 on 2018/5/25.
 */

public interface RizhiView extends BaseView {

    void onGetRizhi(List<RizhiData> data);
}

package com.ylxt.gpmanagement.work.presenter.view;

import com.ylxt.gpmanagement.base.presenter.view.BaseView;
import com.ylxt.gpmanagement.work.data.gson.Xin;
import com.ylxt.gpmanagement.work.data.gson.XinData;

import java.util.List;

/**
 * Created by 江婷婷 on 2018/5/24.
 */

public interface ShouxinView extends BaseView {
    void onShouxinSucc(List<XinData> data);
}

package com.ylxt.gpmanagement.teacher.presenter.view;

import com.ylxt.gpmanagement.base.presenter.view.BaseView;
import com.ylxt.gpmanagement.work.data.gson.SubjectData;

import java.util.List;

/**
 * Created by 江婷婷 on 2018/5/25.
 */

public interface ShenbaoView extends BaseView {
    void onGetShenbao(List<SubjectData> data);
}

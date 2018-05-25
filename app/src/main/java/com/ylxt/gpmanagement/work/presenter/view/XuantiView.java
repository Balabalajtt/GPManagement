package com.ylxt.gpmanagement.work.presenter.view;

import com.ylxt.gpmanagement.base.presenter.view.BaseView;
import com.ylxt.gpmanagement.work.data.gson.SubjectData;

import java.util.List;

/**
 * Created by 江婷婷 on 2018/5/24.
 */

public interface XuantiView extends BaseView {
    void onChooseSubject(int status, String msg);

    void onGetSubjects(List<SubjectData> data);

    void onUnChoose();

    void onChoosed(SubjectData data);

    void onBujinqu(String msg);
}

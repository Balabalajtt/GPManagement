package com.ylxt.gpmanagement.work.presenter;

import com.ylxt.gpmanagement.base.presenter.BasePresenter;
import com.ylxt.gpmanagement.base.rx.BaseSubscriber;
import com.ylxt.gpmanagement.work.data.gson.Teacher;
import com.ylxt.gpmanagement.work.presenter.view.ThirdView;
import com.ylxt.gpmanagement.work.service.impl.ThirdServiceImpl;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 江婷婷 on 2018/5/24.
 */

public class ThirdPresenter extends BasePresenter<ThirdView> {
    public void getTeacherInfo() {
        new ThirdServiceImpl().getTeacherInfo()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new BaseSubscriber<Teacher>() {
                    @Override
                    public void onNext(Teacher teacher) {
                        super.onNext(teacher);
                        if (teacher.status == 1) {
                            mView.onTeacherInfoSucc(teacher.data);
                        } else {
                            mView.onTeacherInfoFail(teacher.msg);
                        }
                    }
                });

    }
}

package com.ylxt.gpmanagement.teacher.presenter;

import com.ylxt.gpmanagement.base.presenter.BasePresenter;
import com.ylxt.gpmanagement.base.rx.BaseSubscriber;
import com.ylxt.gpmanagement.teacher.presenter.view.ShenbaoView;
import com.ylxt.gpmanagement.teacher.service.impl.TeacherServiceImpl;
import com.ylxt.gpmanagement.work.data.gson.Shengbao;
import com.ylxt.gpmanagement.work.data.gson.Subject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 江婷婷 on 2018/5/25.
 */

public class ShenbaoPresenter extends BasePresenter<ShenbaoView> {
    public void getShenbao() {
        new TeacherServiceImpl().getShenbao()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new BaseSubscriber<Subject>() {
                    @Override
                    public void onNext(Subject subject) {
                        super.onNext(subject);
                        if (subject.status == 1) {
                            mView.onGetShenbao(subject.data);
                        }
                    }
                });
    }
}

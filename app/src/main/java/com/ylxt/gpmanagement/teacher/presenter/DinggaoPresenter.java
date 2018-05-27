package com.ylxt.gpmanagement.teacher.presenter;

import android.util.Log;

import com.ylxt.gpmanagement.base.presenter.BasePresenter;
import com.ylxt.gpmanagement.base.rx.BaseSubscriber;
import com.ylxt.gpmanagement.teacher.presenter.view.DinggaoView;
import com.ylxt.gpmanagement.teacher.presenter.view.ZhongqiView;
import com.ylxt.gpmanagement.teacher.service.impl.TeacherServiceImpl;
import com.ylxt.gpmanagement.work.data.gson.DinggaoAll;
import com.ylxt.gpmanagement.work.data.gson.ZhongqiAll;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 江婷婷 on 2018/5/25.
 */

public class DinggaoPresenter extends BasePresenter<DinggaoView> {

    private static final String TAG = "DinggaoPresenter";

    public void getDinggao() {

        new TeacherServiceImpl().getDinggao()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new BaseSubscriber<DinggaoAll>() {
                    @Override
                    public void onNext(DinggaoAll dinggaoAll) {
                        super.onNext(dinggaoAll);
                        Log.d(TAG, "onNext: " + dinggaoAll.status + dinggaoAll.msg);
                        if (dinggaoAll.status == 1) {
                            mView.onGetDinggao(dinggaoAll.data);
                        }
                    }
                });
    }
}

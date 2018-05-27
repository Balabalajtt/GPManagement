package com.ylxt.gpmanagement.teacher.presenter;

import android.util.Log;

import com.ylxt.gpmanagement.base.presenter.BasePresenter;
import com.ylxt.gpmanagement.base.rx.BaseSubscriber;
import com.ylxt.gpmanagement.teacher.presenter.view.KaitiView;
import com.ylxt.gpmanagement.teacher.presenter.view.ZhongqiView;
import com.ylxt.gpmanagement.teacher.service.impl.TeacherServiceImpl;
import com.ylxt.gpmanagement.work.data.gson.KaitiAll;
import com.ylxt.gpmanagement.work.data.gson.Zhongqi;
import com.ylxt.gpmanagement.work.data.gson.ZhongqiAll;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 江婷婷 on 2018/5/25.
 */

public class ZhongqiPresenter extends BasePresenter<ZhongqiView> {

    private static final String TAG = "ZhongqiPresenter";

    public void getZhongqi() {
        new TeacherServiceImpl().getZhongqi()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new BaseSubscriber<ZhongqiAll>() {
                    @Override
                    public void onNext(ZhongqiAll zhongqiAll) {
                        super.onNext(zhongqiAll);
                        Log.d(TAG, "onNext: " + zhongqiAll.status + zhongqiAll.msg);
                        if (zhongqiAll.status == 1) {
                            mView.onGetZhongqi(zhongqiAll.data);
                        }
                    }
                });
    }
}

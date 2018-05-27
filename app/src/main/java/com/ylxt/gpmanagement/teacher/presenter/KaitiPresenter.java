package com.ylxt.gpmanagement.teacher.presenter;

import android.util.Log;

import com.ylxt.gpmanagement.base.presenter.BasePresenter;
import com.ylxt.gpmanagement.base.rx.BaseSubscriber;
import com.ylxt.gpmanagement.teacher.presenter.view.KaitiView;
import com.ylxt.gpmanagement.teacher.service.impl.TeacherServiceImpl;
import com.ylxt.gpmanagement.work.data.gson.Kaiti;
import com.ylxt.gpmanagement.work.data.gson.KaitiAll;
import com.ylxt.gpmanagement.work.data.gson.Subject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 江婷婷 on 2018/5/25.
 */

public class KaitiPresenter extends BasePresenter<KaitiView> {
    private static final String TAG = "KaitiPresenter";
    public void getKaiti() {
        new TeacherServiceImpl().getKaiti()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new BaseSubscriber<KaitiAll>() {
                    @Override
                    public void onNext(KaitiAll kaiti) {
                        super.onNext(kaiti);
                        Log.d(TAG, "onNext: " + kaiti.status + kaiti.msg);
                        if (kaiti.status == 1) {
                            mView.onGetKaiti(kaiti.data);
                        }
                    }
                });
    }
}

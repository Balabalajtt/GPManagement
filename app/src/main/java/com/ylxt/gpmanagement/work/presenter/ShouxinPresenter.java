package com.ylxt.gpmanagement.work.presenter;

import android.util.Log;

import com.ylxt.gpmanagement.base.presenter.BasePresenter;
import com.ylxt.gpmanagement.base.rx.BaseSubscriber;
import com.ylxt.gpmanagement.work.data.gson.Xin;
import com.ylxt.gpmanagement.work.presenter.view.ShouxinView;
import com.ylxt.gpmanagement.work.service.impl.XinServiceImpl;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 江婷婷 on 2018/5/24.
 */

public class ShouxinPresenter extends BasePresenter<ShouxinView> {

    private static final String TAG = "ShouxinPresenter";

    public void getShouxin() {
        new XinServiceImpl().getShouXin()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new BaseSubscriber<Xin>() {
                    @Override
                    public void onNext(Xin xin) {
                        super.onNext(xin);
                        Log.d(TAG, "onNext: " + xin.msg);
                        if (xin.status == 1) {
                            mView.onShouxinSucc(xin.data);
                        }
                    }
                });
    }

    public void getFaXin() {
        new XinServiceImpl().getFaXin()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new BaseSubscriber<Xin>() {
                    @Override
                    public void onNext(Xin xin) {
                        super.onNext(xin);
                        Log.d(TAG, "onNext: " + xin.msg);
                        if (xin.status == 1) {
                            mView.onShouxinSucc(xin.data);
                        }
                    }
                });
    }
}

package com.ylxt.gpmanagement.work.presenter;

import com.ylxt.gpmanagement.base.presenter.BasePresenter;
import com.ylxt.gpmanagement.base.presenter.view.BaseView;
import com.ylxt.gpmanagement.base.rx.BaseSubscriber;
import com.ylxt.gpmanagement.work.data.gson.Rizhi;
import com.ylxt.gpmanagement.work.presenter.view.RizhiView;
import com.ylxt.gpmanagement.work.service.impl.RizhiServiceImpl;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 江婷婷 on 2018/5/25.
 */

public class RizhiPresenter extends BasePresenter<RizhiView> {

    public void getRizhi() {
        new RizhiServiceImpl().getRizhi()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new BaseSubscriber<Rizhi>() {
                    @Override
                    public void onNext(Rizhi rizhi) {
                        super.onNext(rizhi);
                        if (rizhi.status == 1) {
                            mView.onGetRizhi(rizhi.data);
                        }
                    }
                });
    }
}

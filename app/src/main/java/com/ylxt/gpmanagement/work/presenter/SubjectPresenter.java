package com.ylxt.gpmanagement.work.presenter;

import android.util.Log;

import com.ylxt.gpmanagement.base.common.Info;
import com.ylxt.gpmanagement.base.presenter.BasePresenter;
import com.ylxt.gpmanagement.base.rx.BaseSubscriber;
import com.ylxt.gpmanagement.work.data.gson.Shengbao;
import com.ylxt.gpmanagement.work.data.gson.Subject;
import com.ylxt.gpmanagement.work.presenter.view.SubjectView;
import com.ylxt.gpmanagement.work.service.SubjectService;
import com.ylxt.gpmanagement.work.service.impl.SubjectServiceImpl;

import org.json.JSONException;

import java.io.IOException;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 江婷婷 on 2018/5/21.
 */

public class SubjectPresenter extends BasePresenter<SubjectView> {
    private static final String TAG = "SubjectPresenter";
    private SubjectService mSubjectService = new SubjectServiceImpl();
    public void checkShengbao() {
        mSubjectService.checkShengbao()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new BaseSubscriber<Shengbao>() {
                    @Override
                    public void onNext(Shengbao shenbao) {
                        super.onNext(shenbao);
                        int status = shenbao.status;
                        String msg = shenbao.msg;
                        Log.d(TAG, "onNext: " + msg);
                        if (status == 1) { //申报过课题
                            Info.mSubjectData = shenbao.data;
                            mView.onShengbao();
                        } else {
                            mView.onUnShengbao(status, msg);
                        }

                    }
                });

    }
}

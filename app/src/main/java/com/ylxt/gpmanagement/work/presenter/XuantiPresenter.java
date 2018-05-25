package com.ylxt.gpmanagement.work.presenter;

import android.util.Log;

import com.ylxt.gpmanagement.base.presenter.BasePresenter;
import com.ylxt.gpmanagement.base.rx.BaseSubscriber;
import com.ylxt.gpmanagement.work.data.gson.Shengbao;
import com.ylxt.gpmanagement.work.data.gson.Subject;
import com.ylxt.gpmanagement.work.presenter.view.XuantiView;
import com.ylxt.gpmanagement.work.service.XuantiService;
import com.ylxt.gpmanagement.work.service.impl.XuantiServiceImpl;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 江婷婷 on 2018/5/24.
 */

public class XuantiPresenter extends BasePresenter<XuantiView> {
    XuantiService mXuantiService = new XuantiServiceImpl();
    private static final String TAG = "XuantiPresenter";

    public void chooseSubject(int id) {
        mXuantiService.chooseSubject(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new BaseSubscriber<ResponseBody>() {
                    @Override
                    public void onNext(ResponseBody responseBody) {
                        super.onNext(responseBody);
                        try {
                            JSONObject jsonObject = new JSONObject(responseBody.string());
                            mView.onChooseSubject(jsonObject.getInt("status"), jsonObject.getString("msg"));
                            Log.d(TAG, "onNext: " + jsonObject.getString("msg"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                });
    }

    public void getSubjects() {
        mXuantiService.getSubjects()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new BaseSubscriber<Subject>() {
                    @Override
                    public void onNext(Subject subject) {
                        super.onNext(subject);
                        mView.onGetSubjects(subject.data);
                    }
                });
    }

    public void checkXuanti() {
        mXuantiService.checkXuanti()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new BaseSubscriber<Shengbao>() {
                    @Override
                    public void onNext(Shengbao shengbao) {
                        super.onNext(shengbao);
                        int status = shengbao.status;
                        String msg = shengbao.msg;
                        if (status == 0) {
                            mView.onUnChoose();
                        } else if (status == 1) {
                            mView.onChoosed(shengbao.data);
                        } else {
                            mView.onBujinqu(msg);
                        }


                    }
                });
    }
}

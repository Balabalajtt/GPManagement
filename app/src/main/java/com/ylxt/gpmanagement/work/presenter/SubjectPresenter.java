package com.ylxt.gpmanagement.work.presenter;

import android.util.Log;

import com.ylxt.gpmanagement.base.common.Info;
import com.ylxt.gpmanagement.base.presenter.BasePresenter;
import com.ylxt.gpmanagement.base.rx.BaseSubscriber;
import com.ylxt.gpmanagement.work.data.gson.ShengbaoData;
import com.ylxt.gpmanagement.work.presenter.view.SubjectView;
import com.ylxt.gpmanagement.work.service.SubjectService;
import com.ylxt.gpmanagement.work.service.impl.SubjectServiceImpl;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
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
                .subscribe(new BaseSubscriber<ResponseBody>() {
                    @Override
                    public void onNext(ResponseBody responseBody) {
                        super.onNext(responseBody);
                        try {
                            JSONObject jsonObject = new JSONObject(responseBody.string());
                            int status = jsonObject.getInt("status");
                            String msg = jsonObject.getString("msg");
                            Log.d(TAG, "onNext: " + msg);
                            if (status == 0) {
                                mView.onUnShengbao();
                            } else {
                                JSONObject jd = jsonObject.getJSONObject("data");
                                Log.d(TAG, "onNext: " + jd);
                                ShengbaoData data = new ShengbaoData(
                                        jd.getInt("id"),
                                        jd.getString("studentName"),
                                        jd.getString("number"),
                                        jd.getString("subjectName"),
                                        jd.getString("topicSource"),
                                        jd.getString("subjectType"),
                                        jd.getString("topicType"),
                                        jd.getString("topicPaper"),
                                        jd.getString("ability"),
                                        jd.getString("target"),
                                        jd.getString("guideTeacher"),
                                        jd.getString("attachment"),
                                        jd.getInt("status")
                                );
                                Info.mShengbaoData = data;
                                mView.onShengbao();

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });

    }
}

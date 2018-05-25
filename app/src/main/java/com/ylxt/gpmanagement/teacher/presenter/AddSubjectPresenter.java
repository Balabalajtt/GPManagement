package com.ylxt.gpmanagement.teacher.presenter;

import com.ylxt.gpmanagement.base.presenter.BasePresenter;
import com.ylxt.gpmanagement.base.rx.BaseSubscriber;
import com.ylxt.gpmanagement.teacher.presenter.view.AddSubjectView;
import com.ylxt.gpmanagement.teacher.service.TeacherService;
import com.ylxt.gpmanagement.teacher.service.impl.TeacherServiceImpl;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 江婷婷 on 2018/5/25.
 */

public class AddSubjectPresenter extends BasePresenter<AddSubjectView> {
    public void publish(String sn, String ts, String st, String tt, String tp, String ab, String tg) {
        new TeacherServiceImpl().publish(sn, ts, st, tt, tp, ab, tg)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new BaseSubscriber<ResponseBody>() {
                    @Override
                    public void onNext(ResponseBody responseBody) {
                        super.onNext(responseBody);
                        try {
                            JSONObject jsonObject = new JSONObject(responseBody.string());
                            mView.onPublish(jsonObject.getInt("status"), jsonObject.getString("msg"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                });

    }
}

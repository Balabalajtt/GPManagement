package com.ylxt.gpmanagement.teacher.presenter;

import android.util.Log;

import com.ylxt.gpmanagement.base.presenter.BasePresenter;
import com.ylxt.gpmanagement.base.rx.BaseSubscriber;
import com.ylxt.gpmanagement.teacher.presenter.view.KaitiShowView;
import com.ylxt.gpmanagement.teacher.presenter.view.ShenbaoShowView;
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

public class KaitiShowPresenter extends BasePresenter<KaitiShowView> {

    private static final String TAG = "KaitiShowPresenter";

    public void dealKaiti(int id, int action, String opinion) {
        new TeacherServiceImpl().dealKaiti(id, action, opinion)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new BaseSubscriber<ResponseBody>() {
                    @Override
                    public void onNext(ResponseBody responseBody) {
                        super.onNext(responseBody);
                        Log.d(TAG, "onNext: " + "sssssssssssssssssss");
                        try {
                            JSONObject jsonObject = new JSONObject(responseBody.string());
                            int status = jsonObject.getInt("status");
                            String msg = jsonObject.getString("msg");
                            Log.d(TAG, "onNext: " + status + msg );
                            mView.onDealKaiti(status, msg);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                });
    }
}

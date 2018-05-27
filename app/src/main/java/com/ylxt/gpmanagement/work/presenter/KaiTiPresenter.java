package com.ylxt.gpmanagement.work.presenter;

import android.util.Log;

import com.ylxt.gpmanagement.base.presenter.BasePresenter;
import com.ylxt.gpmanagement.base.rx.BaseSubscriber;
import com.ylxt.gpmanagement.work.data.gson.Kaiti;
import com.ylxt.gpmanagement.work.presenter.view.KaiTiView;
import com.ylxt.gpmanagement.work.presenter.view.ZhongqiView;
import com.ylxt.gpmanagement.work.service.KaiTiService;
import com.ylxt.gpmanagement.work.service.impl.KaiTiServiceImpl;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 江婷婷 on 2018/5/20.
 */

public class KaiTiPresenter extends BasePresenter<KaiTiView> {

    private static final String TAG = "KaiTiPresenter";
    private KaiTiService mService = new KaiTiServiceImpl();

    public void postKaiTFujian(MultipartBody.Part body) {
        mService.postKaiTiFujian(1, body)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new BaseSubscriber<ResponseBody>() {
                    @Override
                    public void onNext(ResponseBody responseBody) {
                        super.onNext(responseBody);
                        try {
                            Log.d(TAG, "onNext: " + responseBody.string());
                            JSONObject jsonObject = new JSONObject(responseBody.string());
                            int status = jsonObject.getInt("status");
                            String msg = jsonObject.getString("msg");
                            Log.d(TAG, "onNext: " + status + msg);
                            mView.onPostFujian(status, msg);
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    public void postKaiTi(String purpose, String basis, String problems, String plan) {
        mService.postKaiTi(purpose, basis, problems, plan)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new BaseSubscriber<ResponseBody>(){
                    @Override
                    public void onNext(ResponseBody responseBody) {
                        super.onNext(responseBody);
                        try {
                            JSONObject jsonObject = new JSONObject(responseBody.string());
                            int status = jsonObject.getInt("status");
                            String msg = jsonObject.getString("msg");
                            Log.d(TAG, "onNext: " + status + msg);
                            mView.onPostKaiti(status, msg);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                });
    }

    public void checkKaiti() {
        mService.checkKaiti()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new BaseSubscriber<Kaiti>() {
                    @Override
                    public void onNext(Kaiti kaiti) {
                        super.onNext(kaiti);
                        int status = kaiti.status;
                        String msg = kaiti.msg;
                        Log.d(TAG, "onNext: " + status + msg);

                        if (status == 3) {
                            mView.onTianxieKaiti(status, msg);
                        } else if (status == 1) {
                            mView.onShowKaiti(kaiti.data);
                        } else {
                            mView.onNotIn(status, msg);
                        }

                    }
                });
    }
}

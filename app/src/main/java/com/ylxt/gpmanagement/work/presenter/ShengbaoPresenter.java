package com.ylxt.gpmanagement.work.presenter;

import android.util.Log;

import com.ylxt.gpmanagement.base.presenter.BasePresenter;
import com.ylxt.gpmanagement.base.rx.BaseSubscriber;
import com.ylxt.gpmanagement.work.presenter.view.ShengbaoView;
import com.ylxt.gpmanagement.work.service.ShengbaoService;
import com.ylxt.gpmanagement.work.service.impl.ShengbaoServceImpl;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 江婷婷 on 2018/5/21.
 */

public class ShengbaoPresenter extends BasePresenter<ShengbaoView> {

    private static final String TAG = "ShengbaoPresenter";
    private ShengbaoService mShengbaoService = new ShengbaoServceImpl();

    public void postFujian(MultipartBody.Part body) {
        mShengbaoService.postFujian(0, body)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new BaseSubscriber<ResponseBody>() {
                    @Override
                    public void onNext(ResponseBody responseBody) {
                        super.onNext(responseBody);
                        try {
                            Log.d(TAG, "onNext: 66666666666666666666666");
                            JSONObject jsonObject = new JSONObject(responseBody.string());
                            int status = jsonObject.getInt("status");
                            String msg = jsonObject.getString("msg");
                            String data = jsonObject.getString("data");
                            Log.d(TAG, "onNext: " + status + msg + "\n" + data);
                            mView.onPostFujian(status, msg);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });

    }

    public void postShengbao(String name, String ts, String st, String tt, String tp, String ab, String ta, String gt) {
        mShengbaoService.postShengbao(name, ts, st, tt, tp, ab, ta, gt)
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
                            mView.onPostShengbao(status, msg);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });

    }
}

package com.ylxt.gpmanagement.work.presenter;

import android.util.Log;

import com.ylxt.gpmanagement.base.presenter.BasePresenter;
import com.ylxt.gpmanagement.base.rx.BaseSubscriber;
import com.ylxt.gpmanagement.work.data.gson.Dinggao;
import com.ylxt.gpmanagement.work.data.gson.Zhongqi;
import com.ylxt.gpmanagement.work.presenter.view.DinggaoView;
import com.ylxt.gpmanagement.work.presenter.view.ZhongqiView;
import com.ylxt.gpmanagement.work.service.KaiTiService;
import com.ylxt.gpmanagement.work.service.impl.KaiTiServiceImpl;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 江婷婷 on 2018/5/20.
 */

public class DinggaoPresenter extends BasePresenter<DinggaoView> {

    private static final String TAG = "DinggaoPresenter";
    private KaiTiService mService = new KaiTiServiceImpl();

    public void postDinggao(List<MultipartBody.Part> parts) {
        mService.postDinggao(4, parts)
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
                            Log.d(TAG, "onNext: " + status + msg);
                            mView.onPost(status, msg);
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    public void checkDinggao() {
        mService.checkDinggao()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new BaseSubscriber<Dinggao>() {
                    @Override
                    public void onNext(Dinggao dinggao) {
                        super.onNext(dinggao);
                        int status = dinggao.status;
                        String msg = dinggao.msg;
                        Log.d(TAG, "onNext: " + status + msg);

                        if (status == 4) {
                            mView.onTianDinggao(status, msg);
                        } else if (status == 1) {
                            mView.onShowDinggao(dinggao.data);
                        } else {
                            mView.onNotIn(status, msg);
                        }

                    }
                });
    }

}

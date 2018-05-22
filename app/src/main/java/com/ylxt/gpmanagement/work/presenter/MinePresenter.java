package com.ylxt.gpmanagement.work.presenter;

import android.util.Log;

import com.ylxt.gpmanagement.base.common.Info;
import com.ylxt.gpmanagement.base.presenter.BasePresenter;
import com.ylxt.gpmanagement.base.rx.BaseSubscriber;
import com.ylxt.gpmanagement.work.presenter.view.MineView;
import com.ylxt.gpmanagement.work.service.MineService;
import com.ylxt.gpmanagement.work.service.impl.MineServiceImpl;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 江婷婷 on 2018/5/21.
 */

public class MinePresenter extends BasePresenter<MineView> {

    private static final String TAG = "MinePresenter";
    private MineService mMineService = new MineServiceImpl();

    public void changePwd(String pwd) {
        mMineService.changePwd(pwd)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new BaseSubscriber<ResponseBody>() {
                    @Override
                    public void onNext(ResponseBody responseBody) {
                        super.onNext(responseBody);
                        try {
                            JSONObject jsonObject = new JSONObject(responseBody.string());
                            mView.onChangePwd(jsonObject.getInt("status"), jsonObject.getString("msg"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                });
    }

    public void logout() {
        mMineService.logout()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new BaseSubscriber<ResponseBody>() {
                    @Override
                    public void onNext(ResponseBody responseBody) {
                        super.onNext(responseBody);

                        try {
                            Log.d(TAG, "onNext: " + responseBody.string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        mView.onLogout();
                    }
                });
    }

    public void changeInfo(final String phone, final String email) {
        mMineService.changeInfo(phone, email)
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
                            if (status == 1) {
                                JSONObject data = jsonObject.getJSONObject("data");
                                Info.email = data.getString("email");
                                Info.phone = data.getString("phone");
                                Log.d(TAG, "onNext: " + email + phone);
                            }
                            mView.onChangeInfo(status, msg);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                });
    }
}

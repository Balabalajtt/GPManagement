package com.ylxt.gpmanagement.work.presenter;

import android.util.Log;

import com.ylxt.gpmanagement.base.common.Constant;
import com.ylxt.gpmanagement.base.common.Info;
import com.ylxt.gpmanagement.base.presenter.BasePresenter;
import com.ylxt.gpmanagement.base.rx.BaseSubscriber;
import com.ylxt.gpmanagement.work.presenter.view.LoginView;
import com.ylxt.gpmanagement.work.service.impl.LoginServiceImpl;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 江婷婷 on 2018/5/15.
 */

public class LoginPresenter extends BasePresenter<LoginView> {

    private static final String TAG = "LoginPresenter";

    public void login(String num, String pwd) {
        new LoginServiceImpl().login(num, pwd)
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
                            if (status == 0) {
                                mView.onLoginFail(msg);
                            } else {
                                JSONObject data = jsonObject.getJSONObject("data");
                                Info.num = data.getString("number");
                                Info.userName = data.getString("username");
                                Info.phone = data.getString("phone");
                                Info.email = data.getString("email");
                                Info.type = data.getInt("type");
                                mView.onLoginSucc(msg);
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

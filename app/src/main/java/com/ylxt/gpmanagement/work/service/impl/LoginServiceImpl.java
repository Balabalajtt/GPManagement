package com.ylxt.gpmanagement.work.service.impl;

import android.util.Log;

import com.ylxt.gpmanagement.base.net.RetrofitFactory;
import com.ylxt.gpmanagement.work.data.api.LoginApi;
import com.ylxt.gpmanagement.work.service.LoginService;

import okhttp3.ResponseBody;
import rx.Observable;

/**
 * Created by 江婷婷 on 2018/5/15.
 */

public class LoginServiceImpl implements LoginService {
    private static final String TAG = "LoginServiceImpl";
    @Override
    public Observable<ResponseBody> login(String num, String pwd) {
        return RetrofitFactory.INSTANCE.create(LoginApi.class)
                .login(num, pwd);
    }
}

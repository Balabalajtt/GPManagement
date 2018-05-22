package com.ylxt.gpmanagement.work.service.impl;

import com.ylxt.gpmanagement.base.net.RetrofitFactory;
import com.ylxt.gpmanagement.work.data.api.MineApi;
import com.ylxt.gpmanagement.work.service.MineService;

import okhttp3.ResponseBody;
import rx.Observable;

/**
 * Created by 江婷婷 on 2018/5/21.
 */

public class MineServiceImpl implements MineService {
    @Override
    public Observable<ResponseBody> changePwd(String pwd) {
        return RetrofitFactory.INSTANCE.create(MineApi.class).changePwd(pwd);
    }

    @Override
    public Observable<ResponseBody> logout() {
        return RetrofitFactory.INSTANCE.create(MineApi.class).logout();
    }

    @Override
    public Observable<ResponseBody> changeInfo(String phone, String email) {
        return RetrofitFactory.INSTANCE.create(MineApi.class).changeInfo(phone, email);
    }
}

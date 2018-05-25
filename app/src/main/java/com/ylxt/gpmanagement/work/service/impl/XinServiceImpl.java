package com.ylxt.gpmanagement.work.service.impl;

import com.ylxt.gpmanagement.base.net.RetrofitFactory;
import com.ylxt.gpmanagement.work.data.api.MineApi;
import com.ylxt.gpmanagement.work.data.gson.Xin;
import com.ylxt.gpmanagement.work.service.XinService;

import rx.Observable;

/**
 * Created by 江婷婷 on 2018/5/24.
 */

public class XinServiceImpl implements XinService {

    @Override
    public Observable<Xin> getShouXin() {
        return RetrofitFactory.INSTANCE.create(MineApi.class).getShouxin();
    }

    public Observable<Xin> getFaXin() {
        return RetrofitFactory.INSTANCE.create(MineApi.class).getFaxin();
    }
}

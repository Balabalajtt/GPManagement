package com.ylxt.gpmanagement.work.service.impl;

import com.ylxt.gpmanagement.base.net.RetrofitFactory;
import com.ylxt.gpmanagement.work.data.api.MineApi;
import com.ylxt.gpmanagement.work.data.gson.Rizhi;
import com.ylxt.gpmanagement.work.service.RizhiService;

import rx.Observable;

/**
 * Created by 江婷婷 on 2018/5/25.
 */

public class RizhiServiceImpl implements RizhiService {
    @Override
    public Observable<Rizhi> getRizhi() {
        return RetrofitFactory.INSTANCE.create(MineApi.class).getRizhi();
    }
}

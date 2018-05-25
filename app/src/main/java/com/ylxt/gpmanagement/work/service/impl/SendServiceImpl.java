package com.ylxt.gpmanagement.work.service.impl;

import com.ylxt.gpmanagement.base.net.RetrofitFactory;
import com.ylxt.gpmanagement.work.data.api.MineApi;
import com.ylxt.gpmanagement.work.service.SendService;

import okhttp3.ResponseBody;
import rx.Observable;

/**
 * Created by 江婷婷 on 2018/5/24.
 */

public class SendServiceImpl implements SendService {
    public Observable<ResponseBody> sendMessage(String name, String content) {
        return RetrofitFactory.INSTANCE.create(MineApi.class).sendMessage(name, content);
    }
}

package com.ylxt.gpmanagement.work.service.impl;

import com.ylxt.gpmanagement.base.net.RetrofitFactory;
import com.ylxt.gpmanagement.work.data.api.SubjectApi;
import com.ylxt.gpmanagement.work.data.gson.Shengbao;
import com.ylxt.gpmanagement.work.service.SubjectService;

import okhttp3.ResponseBody;
import rx.Observable;

/**
 * Created by 江婷婷 on 2018/5/21.
 */

public class SubjectServiceImpl implements SubjectService {
    @Override
    public Observable<Shengbao> checkShengbao() {
        return RetrofitFactory.INSTANCE.create(SubjectApi.class).checkShengbao();
    }
}

package com.ylxt.gpmanagement.work.service.impl;

import com.ylxt.gpmanagement.base.net.RetrofitFactory;
import com.ylxt.gpmanagement.work.data.api.SubjectApi;
import com.ylxt.gpmanagement.work.data.gson.Shengbao;
import com.ylxt.gpmanagement.work.data.gson.Subject;
import com.ylxt.gpmanagement.work.service.XuantiService;

import okhttp3.ResponseBody;
import rx.Observable;

/**
 * Created by 江婷婷 on 2018/5/24.
 */

public class XuantiServiceImpl implements XuantiService {
    @Override
    public Observable<ResponseBody> chooseSubject(int id) {
        return RetrofitFactory.INSTANCE.create(SubjectApi.class).chooseSubject(id);
    }

    @Override
    public Observable<Subject> getSubjects() {
        return RetrofitFactory.INSTANCE.create(SubjectApi.class).getSubjects();
    }

    @Override
    public Observable<Shengbao> checkXuanti() {
        return RetrofitFactory.INSTANCE.create(SubjectApi.class).checkXuanti();
    }
}

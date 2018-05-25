package com.ylxt.gpmanagement.work.service.impl;

import com.ylxt.gpmanagement.base.net.RetrofitFactory;
import com.ylxt.gpmanagement.work.data.api.MineApi;
import com.ylxt.gpmanagement.work.data.gson.Teacher;
import com.ylxt.gpmanagement.work.service.ThirdService;

import rx.Observable;

/**
 * Created by 江婷婷 on 2018/5/24.
 */

public class ThirdServiceImpl implements ThirdService {

    @Override
    public Observable<Teacher> getTeacherInfo() {
        return RetrofitFactory.INSTANCE.create(MineApi.class).getTeacherInfo();
    }
}

package com.ylxt.gpmanagement.teacher.service.impl;

import com.ylxt.gpmanagement.base.net.RetrofitFactory;
import com.ylxt.gpmanagement.teacher.data.api.TeacherApi;
import com.ylxt.gpmanagement.teacher.service.TeacherService;
import com.ylxt.gpmanagement.teacher.ui.activity.TeacherAllSubjectActivity;
import com.ylxt.gpmanagement.work.data.gson.Shengbao;
import com.ylxt.gpmanagement.work.data.gson.Subject;
import com.ylxt.gpmanagement.work.data.gson.Teacher;

import okhttp3.ResponseBody;
import rx.Observable;

/**
 * Created by 江婷婷 on 2018/5/25.
 */

public class TeacherServiceImpl implements TeacherService {
    @Override
    public Observable<Subject> getShenbao() {
        return RetrofitFactory.INSTANCE.create(TeacherApi.class).getUnShenbao();
    }

    @Override
    public Observable<ResponseBody> dealShenbao(int id, int action) {
        return RetrofitFactory.INSTANCE.create(TeacherApi.class).dealShenbao(id, action);
    }

    public Observable<ResponseBody> publish(String sn, String ts, String st, String tt, String tp, String ab, String tg) {
        return RetrofitFactory.INSTANCE.create(TeacherApi.class).publish(sn, ts, st, tt, tp, ab, tg);
    }
}

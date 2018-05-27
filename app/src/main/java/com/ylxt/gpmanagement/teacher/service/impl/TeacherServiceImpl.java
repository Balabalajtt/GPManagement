package com.ylxt.gpmanagement.teacher.service.impl;

import com.ylxt.gpmanagement.base.net.RetrofitFactory;
import com.ylxt.gpmanagement.teacher.data.api.TeacherApi;
import com.ylxt.gpmanagement.teacher.service.TeacherService;
import com.ylxt.gpmanagement.teacher.ui.activity.TeacherAllSubjectActivity;
import com.ylxt.gpmanagement.work.data.gson.DinggaoAll;
import com.ylxt.gpmanagement.work.data.gson.Kaiti;
import com.ylxt.gpmanagement.work.data.gson.KaitiAll;
import com.ylxt.gpmanagement.work.data.gson.KaitiData;
import com.ylxt.gpmanagement.work.data.gson.Shengbao;
import com.ylxt.gpmanagement.work.data.gson.Subject;
import com.ylxt.gpmanagement.work.data.gson.Teacher;
import com.ylxt.gpmanagement.work.data.gson.ZhongqiAll;

import okhttp3.ResponseBody;
import rx.Completable;
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

    public Observable<KaitiAll> getKaiti() {
        return RetrofitFactory.INSTANCE.create(TeacherApi.class).getKaiti();
    }

    public Observable<ResponseBody> dealKaiti(int id, int action, String opinion) {
        return RetrofitFactory.INSTANCE.create(TeacherApi.class).dealKaiti(id, action, opinion);
    }

    public Observable<ZhongqiAll> getZhongqi() {
        return RetrofitFactory.INSTANCE.create(TeacherApi.class).getZhongqi();
    }

    public Observable<ResponseBody> dealZhongqi(int id, int action) {
        return RetrofitFactory.INSTANCE.create(TeacherApi.class).dealZhongqi(id, action);
    }

    public Observable<DinggaoAll> getDinggao() {
        return RetrofitFactory.INSTANCE.create(TeacherApi.class).getDinggao();
    }

    public Observable<ResponseBody> dealDinggao(int id, int action, int score, String message) {
        return RetrofitFactory.INSTANCE.create(TeacherApi.class).dealDinggao(id, action, score, message);
    }
}

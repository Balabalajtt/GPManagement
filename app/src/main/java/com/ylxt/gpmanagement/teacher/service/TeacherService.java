package com.ylxt.gpmanagement.teacher.service;

import com.ylxt.gpmanagement.work.data.gson.Shengbao;
import com.ylxt.gpmanagement.work.data.gson.Subject;

import okhttp3.ResponseBody;
import rx.Observable;

/**
 * Created by 江婷婷 on 2018/5/25.
 */

public interface TeacherService {
    Observable<Subject> getShenbao();

    Observable<ResponseBody> dealShenbao(int id, int action);
}

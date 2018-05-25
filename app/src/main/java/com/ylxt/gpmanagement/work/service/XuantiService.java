package com.ylxt.gpmanagement.work.service;

import com.ylxt.gpmanagement.work.data.gson.Shengbao;
import com.ylxt.gpmanagement.work.data.gson.Subject;

import okhttp3.ResponseBody;
import rx.Observable;

/**
 * Created by 江婷婷 on 2018/5/24.
 */

public interface XuantiService {
    Observable<ResponseBody> chooseSubject(int id);

    Observable<Subject> getSubjects();

    Observable<Shengbao> checkXuanti();
}

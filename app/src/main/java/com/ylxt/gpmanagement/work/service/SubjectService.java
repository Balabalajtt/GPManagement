package com.ylxt.gpmanagement.work.service;

import com.ylxt.gpmanagement.work.data.gson.Shengbao;

import okhttp3.ResponseBody;
import rx.Observable;

/**
 * Created by 江婷婷 on 2018/5/21.
 */

public interface SubjectService {
    Observable<Shengbao> checkShengbao();
}

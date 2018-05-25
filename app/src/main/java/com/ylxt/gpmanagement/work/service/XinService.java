package com.ylxt.gpmanagement.work.service;

import com.ylxt.gpmanagement.work.data.gson.Shengbao;
import com.ylxt.gpmanagement.work.data.gson.Xin;

import rx.Observable;

/**
 * Created by 江婷婷 on 2018/5/24.
 */

public interface XinService {
    Observable<Xin> getShouXin();
}

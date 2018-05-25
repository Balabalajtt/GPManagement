package com.ylxt.gpmanagement.work.service;

import com.ylxt.gpmanagement.work.data.gson.Rizhi;

import rx.Observable;

/**
 * Created by 江婷婷 on 2018/5/25.
 */

public interface RizhiService {
    Observable<Rizhi> getRizhi();
}

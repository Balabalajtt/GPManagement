package com.ylxt.gpmanagement.work.service;

import okhttp3.ResponseBody;
import rx.Observable;

/**
 * Created by 江婷婷 on 2018/5/24.
 */

public interface SendService {
    Observable<ResponseBody> sendMessage(String name, String content);
}

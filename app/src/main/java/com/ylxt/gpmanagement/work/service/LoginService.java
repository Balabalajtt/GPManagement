package com.ylxt.gpmanagement.work.service;

import okhttp3.ResponseBody;
import rx.Observable;

/**
 * Created by 江婷婷 on 2018/5/15.
 */

public interface LoginService {
    Observable<ResponseBody> login(String num, String pwd);
}

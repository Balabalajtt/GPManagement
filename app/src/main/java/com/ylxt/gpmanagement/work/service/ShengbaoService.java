package com.ylxt.gpmanagement.work.service;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import rx.Completable;
import rx.Observable;

/**
 * Created by 江婷婷 on 2018/5/21.
 */

public interface ShengbaoService {
    Observable<ResponseBody> postShengbao(String name, String ts, String st, String tt, String tp, String ab, String ta, String gt);

    Observable<ResponseBody> postFujian(int type, MultipartBody.Part body);
}

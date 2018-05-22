package com.ylxt.gpmanagement.work.service.impl;

import com.ylxt.gpmanagement.base.net.RetrofitFactory;
import com.ylxt.gpmanagement.work.data.api.SubjectApi;
import com.ylxt.gpmanagement.work.service.ShengbaoService;

import okhttp3.ResponseBody;
import rx.Observable;

/**
 * Created by 江婷婷 on 2018/5/21.
 */

public class ShengbaoServceImpl implements ShengbaoService {

    @Override
    public Observable<ResponseBody> postShengbao(String name, String ts, String st, String tt, String tp, String ab, String ta, String gt) {
        return RetrofitFactory.INSTANCE.create(SubjectApi.class).postShengbao(name, ts, st, tt, tp, ab, ta, gt);
    }
}

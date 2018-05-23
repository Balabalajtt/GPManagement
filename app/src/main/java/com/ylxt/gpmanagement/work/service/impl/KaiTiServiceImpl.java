package com.ylxt.gpmanagement.work.service.impl;

import com.ylxt.gpmanagement.base.net.RetrofitFactory;
import com.ylxt.gpmanagement.work.data.api.SubjectApi;
import com.ylxt.gpmanagement.work.service.KaiTiService;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import rx.Observable;

/**
 * Created by 江婷婷 on 2018/5/21.
 */

public class KaiTiServiceImpl implements KaiTiService {

    @Override
    public Observable<ResponseBody> postKaiTiFujian(int type, MultipartBody.Part body) {
        return RetrofitFactory.INSTANCE.create(SubjectApi.class)
                .postFujian(type, body);
    }

    @Override
    public Observable<ResponseBody> postKaiTi() {
        return RetrofitFactory.INSTANCE.create(SubjectApi.class)
                .postKaiTi("", "");
    }
}

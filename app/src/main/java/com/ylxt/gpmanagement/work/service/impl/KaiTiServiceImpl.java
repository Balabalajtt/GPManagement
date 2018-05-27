package com.ylxt.gpmanagement.work.service.impl;

import com.ylxt.gpmanagement.base.net.RetrofitFactory;
import com.ylxt.gpmanagement.work.data.api.SubjectApi;
import com.ylxt.gpmanagement.work.data.gson.Dinggao;
import com.ylxt.gpmanagement.work.data.gson.Kaiti;
import com.ylxt.gpmanagement.work.data.gson.Zhongqi;
import com.ylxt.gpmanagement.work.service.KaiTiService;

import java.util.List;

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
    public Observable<ResponseBody> postKaiTi(String purpose, String basis, String problems, String plan) {
        return RetrofitFactory.INSTANCE.create(SubjectApi.class)
                .postKaiTi(purpose, basis, problems, plan);
    }

    @Override
    public Observable<Kaiti> checkKaiti() {
        return RetrofitFactory.INSTANCE.create(SubjectApi.class)
                .checkKaiti();
    }

    @Override
    public Observable<ResponseBody> postZhongqi(String area, String conclusion) {
        return RetrofitFactory.INSTANCE.create(SubjectApi.class)
                .postZhongqi(area, conclusion);
    }

    @Override
    public Observable<Zhongqi> checkZhongqi() {
        return RetrofitFactory.INSTANCE.create(SubjectApi.class)
                .checkZhongqi();
    }

    @Override
    public Observable<ResponseBody> postDinggao(int type, List<MultipartBody.Part> parts) {
        return RetrofitFactory.INSTANCE.create(SubjectApi.class)
                .postDinggao(type, parts);
    }

    @Override
    public Observable<Dinggao> checkDinggao() {
        return RetrofitFactory.INSTANCE.create(SubjectApi.class)
                .checkDinggao();
    }
}

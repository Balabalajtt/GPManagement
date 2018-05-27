package com.ylxt.gpmanagement.work.service;

import com.ylxt.gpmanagement.work.data.gson.Dinggao;
import com.ylxt.gpmanagement.work.data.gson.Kaiti;
import com.ylxt.gpmanagement.work.data.gson.Zhongqi;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import rx.Observable;

/**
 * Created by 江婷婷 on 2018/5/21.
 */

public interface KaiTiService {
    Observable<ResponseBody> postKaiTiFujian(int type, MultipartBody.Part body);
    Observable<ResponseBody> postKaiTi(String purpose, String basis, String problems, String plan);

    Observable<Kaiti> checkKaiti();

    Observable<ResponseBody> postZhongqi(String area, String conclusion);

    Observable<Zhongqi> checkZhongqi();

    Observable<ResponseBody> postDinggao(int type, List<MultipartBody.Part> parts);

    Observable<Dinggao> checkDinggao();
}

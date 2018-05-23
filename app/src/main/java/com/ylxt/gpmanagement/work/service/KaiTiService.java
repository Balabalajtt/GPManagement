package com.ylxt.gpmanagement.work.service;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import rx.Observable;

/**
 * Created by 江婷婷 on 2018/5/21.
 */

public interface KaiTiService {
    Observable<ResponseBody> postKaiTiFujian(int type, MultipartBody.Part body);
    Observable<ResponseBody> postKaiTi();

}

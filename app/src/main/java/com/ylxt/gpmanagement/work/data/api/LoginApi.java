package com.ylxt.gpmanagement.work.data.api;

import com.ylxt.gpmanagement.base.common.Constant;

import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by 江婷婷 on 2018/5/15.
 */

public interface LoginApi {
    @POST(Constant.LOGIN)
    @FormUrlEncoded
    @Headers("Content-Type: application/x-www-form-urlencoded")
    Observable<ResponseBody> login(@Field("number") String num, @Field("password") String pwd);

}

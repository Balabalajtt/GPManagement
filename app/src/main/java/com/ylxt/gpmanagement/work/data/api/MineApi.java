package com.ylxt.gpmanagement.work.data.api;

import com.ylxt.gpmanagement.base.common.Constant;
import com.ylxt.gpmanagement.work.data.gson.Rizhi;
import com.ylxt.gpmanagement.work.data.gson.Teacher;
import com.ylxt.gpmanagement.work.data.gson.Xin;

import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by 江婷婷 on 2018/5/21.
 */

public interface MineApi {
    @POST(Constant.CHANGEPWD)
    @FormUrlEncoded
    @Headers("Content-Type: application/x-www-form-urlencoded")
    Observable<ResponseBody> changePwd(@Field("newPassword") String pwd);

    @POST(Constant.LOGOUT)
    Observable<ResponseBody> logout();

    @POST(Constant.CHANGEINFO)
    @FormUrlEncoded
    @Headers("Content-Type: application/x-www-form-urlencoded")
    Observable<ResponseBody> changeInfo(@Field("phone") String phone, @Field("email") String email);


    @POST(Constant.TEACHERINFO)
    Observable<Teacher> getTeacherInfo();

    @POST(Constant.SHOUXIN)
    Observable<Xin> getShouxin();

    @POST(Constant.SENDMESSAGE)
    @FormUrlEncoded
    @Headers("Content-Type: application/x-www-form-urlencoded")
    Observable<ResponseBody> sendMessage(@Field("targetName") String name, @Field("message") String content);

    @POST(Constant.FAXIN)
    Observable<Xin> getFaxin();

    @POST(Constant.RIZHI)
    Observable<Rizhi> getRizhi();
}

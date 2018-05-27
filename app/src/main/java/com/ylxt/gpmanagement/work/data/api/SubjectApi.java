package com.ylxt.gpmanagement.work.data.api;

import com.ylxt.gpmanagement.base.common.Constant;
import com.ylxt.gpmanagement.work.data.gson.Dinggao;
import com.ylxt.gpmanagement.work.data.gson.Kaiti;
import com.ylxt.gpmanagement.work.data.gson.Shengbao;
import com.ylxt.gpmanagement.work.data.gson.Subject;
import com.ylxt.gpmanagement.work.data.gson.Zhongqi;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by 江婷婷 on 2018/5/21.
 */

public interface SubjectApi {

    @Multipart
    @POST(Constant.FUJIAN)
    Observable<ResponseBody> postFujian(@Part("type") int type, @Part MultipartBody.Part file);

    @POST(Constant.CHECK_SHENGBAO)
    Observable<Shengbao> checkShengbao();

    @POST(Constant.KAITI)
    @FormUrlEncoded
    @Headers("Content-Type: application/x-www-form-urlencoded")
    Observable<ResponseBody> postKaiTi(@Field("purpose") String purpose, @Field("basis") String basis, @Field("problems") String problems, @Field("plan") String plan);

    @POST(Constant.SHENGBAO)
    @FormUrlEncoded
    @Headers("Content-Type: application/x-www-form-urlencoded")
    Observable<ResponseBody> postShengbao(@Field("subjectName") String name,
                                          @Field("topicSource") String ts,
                                          @Field("subjectType") String st,
                                          @Field("topicType") String tt,
                                          @Field("topicPaper") String tp,
                                          @Field("ability") String ab,
                                          @Field("target") String ta,
                                          @Field("guideTeacher") String gt);

    @POST(Constant.XUANTI)
    @FormUrlEncoded
    @Headers("Content-Type: application/x-www-form-urlencoded")
    Observable<ResponseBody> chooseSubject(@Field("id") int id);

    @POST(Constant.NENGXUANDETI)
    Observable<Subject> getSubjects();

    @POST(Constant.CHECK_XUANTI)
    Observable<Shengbao> checkXuanti();

    @POST(Constant.CHECK_KAITI)
    Observable<Kaiti> checkKaiti();


    @POST(Constant.ZHONGQI)
    @FormUrlEncoded
    @Headers("Content-Type: application/x-www-form-urlencoded")
    Observable<ResponseBody> postZhongqi(@Field("designArea") String area, @Field("midConclusion") String conclusion);

    @POST(Constant.CHECK_ZHONGQI)
    Observable<Zhongqi> checkZhongqi();

    @Multipart
    @POST(Constant.DINGGAO)
    Observable<ResponseBody> postDinggao(@Part("type") int type, @Part List<MultipartBody.Part> parts);

    @POST(Constant.CHECK_DINGGAO)
    Observable<Dinggao> checkDinggao();

    @POST(Constant.CHECK_DABIAN)
    Observable<Dinggao> checkDabian();
}

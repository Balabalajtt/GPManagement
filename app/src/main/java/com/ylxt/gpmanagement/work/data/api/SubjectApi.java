package com.ylxt.gpmanagement.work.data.api;

import com.ylxt.gpmanagement.base.common.Constant;

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
    Observable<ResponseBody> checkShengbao();

    @POST("subject/get_{type}_subject.do")
    Observable<ResponseBody> check(@Path("type") String type);


    @POST(Constant.KAITI)
    @FormUrlEncoded
    @Headers("Content-Type: application/x-www-form-urlencoded")
    Observable<ResponseBody> postKaiTi(@Field("..") String aa, @Field("..") String bb);

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


}

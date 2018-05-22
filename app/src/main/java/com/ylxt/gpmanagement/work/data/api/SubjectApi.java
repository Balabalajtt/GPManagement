package com.ylxt.gpmanagement.work.data.api;

import com.ylxt.gpmanagement.base.common.Constant;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import rx.Observable;

/**
 * Created by 江婷婷 on 2018/5/21.
 */

public interface SubjectApi {

    @Multipart
    @POST(Constant.KAITIFUJIAN)
    Observable<ResponseBody> postKaiTiFujian(@Part() MultipartBody.Part file);

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

    @POST(Constant.CHECK_SHENGBAO)
    Observable<ResponseBody> checkShengbao();

}

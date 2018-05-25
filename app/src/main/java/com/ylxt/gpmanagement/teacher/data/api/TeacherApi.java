package com.ylxt.gpmanagement.teacher.data.api;

import com.ylxt.gpmanagement.base.common.Constant;
import com.ylxt.gpmanagement.work.data.gson.Shengbao;
import com.ylxt.gpmanagement.work.data.gson.Subject;

import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by 江婷婷 on 2018/5/25.
 */

public interface TeacherApi {
    @POST(Constant.TESHENBAO)
    Observable<Subject> getUnShenbao();

    @POST(Constant.DEALSHENBAO)
    @FormUrlEncoded
    @Headers("Content-Type: application/x-www-form-urlencoded")
    Observable<ResponseBody> dealShenbao(@Field("id") int id, @Field("answer") int action);

    @POST(Constant.PUBLISH)
    @FormUrlEncoded
    @Headers("Content-Type: application/x-www-form-urlencoded")
    Observable<ResponseBody> publish(@Field("subjectName") String name,
                                     @Field("topicSource") String ts,
                                     @Field("subjectType") String st,
                                     @Field("topicType") String tt,
                                     @Field("topicPaper") String tp,
                                     @Field("ability") String ab,
                                     @Field("target") String ta);

}

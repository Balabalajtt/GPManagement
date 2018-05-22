package com.ylxt.gpmanagement.base.net;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.ylxt.gpmanagement.base.common.Constant;

import java.io.IOException;
import java.util.Objects;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import rx.Observable;
import rx.functions.Action1;

/**
 * Created by 江婷婷 on 2018/5/15.
 */

public class AddCookiesInterceptor implements Interceptor {

    private static final String TAG = "AddCookiesInterceptor";
    
    public AddCookiesInterceptor() {
        super();
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        final Request.Builder builder = chain.request().newBuilder();
        SharedPreferences sharedPreferences = Constant.context.getSharedPreferences("cookie", Context.MODE_PRIVATE);
        Observable.just(sharedPreferences.getString("cookie", ""))
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String cookie) {
                        //添加cookie
                        if (!Objects.equals(cookie, "")) {
                            Log.d(TAG, "call: " + cookie);
                            builder.addHeader("Cookie", cookie);
                        }
                    }
                });
        return chain.proceed(builder.build());
    }
}


package com.template.data.remote;

import android.support.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class BaseIntercepter implements Interceptor {

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request request = chain.request();

        Request.Builder builder = chain.request().newBuilder();
        //TODO add header info
//        builder.addHeader("platform", "android(" + Build.VERSION.RELEASE + ")");

        Request newRequest = builder.build();

        return chain.proceed(newRequest);
    }
}

package com.template.base;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.template.data.remote.ApiResponse;
import com.template.utils.JsonUtil;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class ApiCallback<T> implements Callback<T> {

    /**
     * handle repose form api
     *
     * @param call
     * @param response
     */
    @Override
    public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {
        if (response.isSuccessful()) {
            handleResponseData(response.body(), response.code());
        } else {
            ResponseBody responseBody = response.errorBody();
            if (responseBody != null) {
                BufferedSource source = responseBody.source();
                try {
                    source.request(Long.MAX_VALUE); // Buffer the entire body.
                } catch (IOException e) {
                    handleException(e);
                }
                Buffer buffer = source.buffer();
                String errorJson = buffer.clone().readString(Charset.forName("UTF-8"));

                handleResponseData(JsonUtil.deserialize(errorJson, (Type) ApiResponse.class), response.code());
            } else {
                handleError(response);
            }
        }
    }

    /**
     * handle service failure
     * @param call
     * @param t
     */
    @Override
    public void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
        if (t instanceof Exception) {
            handleException(((Exception) t));
        } else {
            // do something else
        }
    }

    /**
     * return data
     * @param data
     * @param code
     */
    abstract void handleResponseData(T data, int code);

    /**
     * handle when have exception
     * @param e
     */
    abstract void handleException(Exception e);

    /**
     * handle error when call api
     * @param response
     */
    private void handleError(Response<T> response) {
        handleException(new Exception(response == null || TextUtils.isEmpty(response.message()) ? "Device not connect internet. please check it." : response.message()));
    }
}
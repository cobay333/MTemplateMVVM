package com.template.base;

import android.arch.lifecycle.LiveData;

import com.template.data.model.api.ApiResponse;
import com.template.data.model.api.Resource;

import retrofit2.Call;

public class BaseRemoteDataSource {
    <T> LiveData<Resource<T>> executeRequest(Call<ApiResponse<T>> call) {
        return new AbstractRequestHandler<T>() {
            @Override
            protected Call<ApiResponse<T>> makeRequest() {
                return call;
            }
        }.doRequest();
    }
}

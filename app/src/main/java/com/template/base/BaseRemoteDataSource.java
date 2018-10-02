package com.template.base;

import android.arch.lifecycle.LiveData;

import com.template.data.remote.ApiResponse;
import com.template.data.remote.Resource;

import retrofit2.Call;

public class BaseRemoteDataSource {
    /**
     * custom execute request retrofit2
     *
     * @param call
     * @param <T>
     * @return
     */
    public <T> LiveData<Resource<T>> executeRequest(Call<ApiResponse<T>> call) {
        return new AbstractRequestHandler<T>() {
            @Override
            protected Call<ApiResponse<T>> makeRequest() {
                return call;
            }
        }.doRequest();
    }
}

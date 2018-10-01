package com.template.data.remote;

import com.template.data.model.api.TestEntity;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("api/product/homepage2")
    Call<ApiResponse<TestEntity>> getHome();
}

package com.template.data.remote;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface ApiService {
    String URL_SERVER = "http://oicsoft.com/api_v1/";

    @GET("/emoployee_list")
    Single<Object> getEmployeeList();
}

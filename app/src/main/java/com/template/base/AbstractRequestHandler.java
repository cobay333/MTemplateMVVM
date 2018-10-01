package com.template.base;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.template.data.remote.ApiResponse;
import com.template.data.remote.Resource;
import com.template.utils.HttpStatus;

import retrofit2.Call;

public abstract class AbstractRequestHandler<M> {

    /**
     * fetch service call
     *
     * @return call
     */
    protected abstract Call<ApiResponse<M>> makeRequest();

    public final LiveData<Resource<M>> doRequest() {
        final MutableLiveData<Resource<M>> liveData = new MutableLiveData<>();
        //start request loading
        liveData.setValue(Resource.loading(null));
        makeRequest().enqueue(new ApiCallback<ApiResponse<M>>() {
            @Override
            void handleResponseData(ApiResponse<M> apiResponse, int code) {
                // success
                if (code == HttpStatus.HTTP_REPONSE_CODE) {
                    liveData.setValue(Resource.success(apiResponse.data));
                } else {
                    liveData.setValue(Resource.error(apiResponse.error, null, apiResponse.status));
                }
            }

            @Override
            void handleException(@NonNull Exception e) {
                liveData.setValue(Resource.error(e.getMessage(), null, HttpStatus.ERROR_CODE_NET_FAIL));
            }
        });
        return liveData;
    }
}


package com.template.base;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import com.template.data.remote.Resource;

public abstract class AbstractResourceObserver<T> implements Observer<Resource<T>> {

    @Override
    public void onChanged(@Nullable Resource<T> resource) {
        if (resource != null) {
            if (!resource.isLoading()) {
                onLoading(false);
                if (resource.isSuccess()) {
                    onSuccess(resource.data);
                } else {
                    onError(resource.message, resource.code);
                }
            } else {
                onLoading(true);
            }
        }
    }

    /**
     * show/hide loading dialog by isLoading
     *
     * @param isLoading
     */
    public void onLoading(boolean isLoading) {
        //no something
    }

    /**
     * success
     *
     * @param data
     */
    public abstract void onSuccess(T data);

    /**
     * error when request data
     *
     * @param errorMsg
     * @param code
     */
    public void onError(String errorMsg, int code) {
        // no something
    }
}

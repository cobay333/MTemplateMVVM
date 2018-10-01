package com.template.data.remote;

import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.template.base.BaseRemoteDataSource;
import com.template.data.model.api.TestEntity;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class RemoteDataSource extends BaseRemoteDataSource implements DataSourceInterface {

    private final ApiService wb;

    @Inject
    RemoteDataSource(@NonNull ApiService wb) {
        this.wb = wb;
    }

    @Override
    public LiveData<Resource<TestEntity>> getHome() {
        return executeRequest(wb.getHome());
    }
}

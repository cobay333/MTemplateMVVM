package com.template.data;

import android.arch.lifecycle.LiveData;

import com.template.data.model.api.TestEntity;
import com.template.data.remote.DataSourceInterface;
import com.template.data.remote.Resource;
import com.template.di.Remote;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DataRepository implements DataSourceInterface {

    private final DataSourceInterface mRemoteDataSource;

    @Inject
    public DataRepository(@Remote DataSourceInterface remoteDataSource) {
        mRemoteDataSource = remoteDataSource;
    }

    @Override
    public LiveData<Resource<TestEntity>> getHome() {
        return mRemoteDataSource.getHome();
    }
}

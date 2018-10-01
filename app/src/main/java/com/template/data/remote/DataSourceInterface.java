package com.template.data.remote;

import android.arch.lifecycle.LiveData;

import com.template.data.model.api.TestEntity;

public interface DataSourceInterface {
    LiveData<Resource<TestEntity>> getHome();
}

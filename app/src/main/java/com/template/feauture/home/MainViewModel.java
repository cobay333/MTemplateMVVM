package com.template.feauture.home;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.template.base.BaseViewModel;
import com.template.data.DataRepository;
import com.template.data.model.api.TestEntity;
import com.template.data.remote.Resource;

public class MainViewModel extends BaseViewModel {
    public final MutableLiveData<String> title = new MutableLiveData<>();

    public MainViewModel(@NonNull Application application, DataRepository dataRepository) {
        super(application, dataRepository);
    }

    public LiveData<Resource<TestEntity>> getHome() {
        return mDataRepository.getHome();
    }
}

package com.template.base;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.template.data.DataRepository;

public class BaseViewModel extends AndroidViewModel {
    protected final DataRepository mDataRepository;
    /**
     * ui request loading status
     */
    public MutableLiveData<Boolean> loading = new MutableLiveData<>();
    /**
     * ui request or verify error info of toast~
     */
    public MutableLiveData<String> toastMsg = new MutableLiveData<>();

    public BaseViewModel(@NonNull Application application, DataRepository dataRepository) {
        super(application);
        this.mDataRepository = dataRepository;
    }
}

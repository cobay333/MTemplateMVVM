package com.template.base;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;

import com.template.base.interfaces.ILifeCycleControl;
import com.template.base.interfaces.ILoadingControl;
import com.template.base.interfaces.IViewModeControl;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseActivity<VM extends BaseViewModel> extends DaggerAppCompatActivity implements ILifeCycleControl, IViewModeControl<VM>, ILoadingControl {

    /**
     * ViewModel
     */
    protected VM viewModel;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        onBeforeSetContentLayout();
        viewModel = obtainViewModel();
        generateContentView(getLayoutId());
        onAfterSetContentLayout(savedInstanceState);
    }

    protected abstract void generateContentView(int layoutResId);

    @Override
    public VM obtainViewModel() {
        if (getModelClass() == null) {
            return null;
        }
        return ViewModelProviders.of(this, viewModelFactory).get(getModelClass());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        hideWaitDialog();
    }
}

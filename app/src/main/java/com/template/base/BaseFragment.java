package com.template.base;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.template.base.interfaces.ILifeCycleControl;
import com.template.base.interfaces.ILoadingControl;
import com.template.base.interfaces.IViewModeControl;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public abstract class BaseFragment<VM extends BaseViewModel> extends DaggerFragment implements ILifeCycleControl, IViewModeControl<VM>, ILoadingControl {


    /**
     * ViewModel
     */
    protected VM viewModel;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    View mView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        onBeforeSetContentLayout();
        viewModel = obtainViewModel();
        if (mView == null) {
            if (getLayoutId() != 0) {
                mView = generateContentView(inflater, getLayoutId(), container, false);
            }
        }
        onAfterSetContentLayout(savedInstanceState);
        ViewGroup parent = (ViewGroup) mView.getParent();
        if (parent != null) {
            parent.removeView(mView);
        }
        return mView;
    }

    abstract View generateContentView(@NonNull LayoutInflater inflater,
                                      int layoutId, @Nullable ViewGroup container, boolean attachToParent);

    @Override
    public VM obtainViewModel() {
        if (getModelClass() == null || getActivity() == null) {
            return null;
        }
        return ViewModelProviders.of(getActivity(), viewModelFactory).get(getModelClass());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        hideWaitDialog();
    }
}

package com.template.base;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;

import com.template.R;
import com.template.base.interfaces.ILifeCycleControl;
import com.template.base.interfaces.ILoadingControl;
import com.template.base.interfaces.IViewModeControl;
import com.template.view.LoadingDialog;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseActivity<VM extends BaseViewModel> extends DaggerAppCompatActivity implements ILifeCycleControl, IViewModeControl<VM>, ILoadingControl {

    /**
     * ViewModel
     */
    protected VM viewModel;

    protected LoadingDialog dialog;
    /**
     * view model factory
     */
    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        onBeforeSetContentLayout();
        viewModel = obtainViewModel();
        generateContentView(getLayoutId());
        dialog = new LoadingDialog(this, ContextCompat.getColor(this, R.color.colorAccent));
        onAfterSetContentLayout(savedInstanceState);
    }

    /**
     * add layout id to activity
     *
     * @param layoutResId
     */
    protected abstract void generateContentView(int layoutResId);

    @Override
    public VM obtainViewModel() {
        if (getModelClass() == null) {
            return null;
        }
        return ViewModelProviders.of(this, viewModelFactory).get(getModelClass());
    }

    @Override
    public void hideWaitDialog() {
        if (dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    @Override
    public void showWaitDialog() {
        if (!dialog.isShowing()) {
            dialog.show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        hideWaitDialog();
    }
}

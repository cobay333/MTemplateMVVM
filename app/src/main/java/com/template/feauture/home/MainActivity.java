package com.template.feauture.home;

import android.os.Bundle;

import com.template.R;
import com.template.base.AbstractResourceObserver;
import com.template.base.BaseActivity;
import com.template.data.model.api.TestEntity;

public class MainActivity extends BaseActivity<MainViewModel> {
    @Override
    protected void generateContentView(int layoutResId) {
        setContentView(layoutResId);
    }

    @Override
    public void onBeforeSetContentLayout() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onAfterSetContentLayout(Bundle savedInstanceState) {
        showWaitDialog();
        viewModel.getHome().observe(this, new AbstractResourceObserver<TestEntity>() {
            @Override
            public void onSuccess(TestEntity data) {
                hideWaitDialog();
            }

            @Override
            public void onError(String errorMsg, int code) {
                super.onError(errorMsg, code);
                hideWaitDialog();
            }
        });
    }

    @Override
    public Class getModelClass() {
        return MainViewModel.class;
    }

    @Override
    public void showToast(String msg) {

    }
}

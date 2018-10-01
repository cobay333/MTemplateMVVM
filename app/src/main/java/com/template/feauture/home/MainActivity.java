package com.template.feauture.home;

import android.app.Dialog;
import android.os.Bundle;

import com.template.R;
import com.template.base.BaseActivity;

public class MainActivity extends BaseActivity<MainViewModel> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

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

    }

    @Override
    public void hideWaitDialog() {

    }

    @Override
    public Dialog showWaitDialog() {
        return null;
    }

    @Override
    public Class getModelClass() {
        return MainActivity.class;
    }

    @Override
    public void showToast(String msg) {

    }
}

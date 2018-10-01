package com.template.base.interfaces;

import android.os.Bundle;

public interface ILifeCycleControl {
    void onBeforeSetContentLayout();

    int getLayoutId();

    void onAfterSetContentLayout(Bundle savedInstanceState);
}

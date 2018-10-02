package com.template.base.interfaces;

import android.os.Bundle;

public interface ILifeCycleControl {
    /**
     * call before set Content layout
     */
    void onBeforeSetContentLayout();

    /**
     * get layout of activity of fragment
     *
     * @return
     */
    int getLayoutId();

    /**
     * after setup layout
     * @param savedInstanceState
     */
    void onAfterSetContentLayout(Bundle savedInstanceState);
}

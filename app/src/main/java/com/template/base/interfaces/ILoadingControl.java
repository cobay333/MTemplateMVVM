package com.template.base.interfaces;

import android.app.Dialog;

public interface ILoadingControl {
    void hideWaitDialog();

    Dialog showWaitDialog();
}

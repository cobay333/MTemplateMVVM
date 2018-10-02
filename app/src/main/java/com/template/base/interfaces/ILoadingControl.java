package com.template.base.interfaces;

public interface ILoadingControl {
    /**
     * dismiss dialog
     */
    void hideWaitDialog();

    /**
     * show waiting dialog
     *
     * @return
     */
    void showWaitDialog();
}

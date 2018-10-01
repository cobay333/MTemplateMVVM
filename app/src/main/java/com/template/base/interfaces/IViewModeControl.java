package com.template.base.interfaces;

import com.template.base.BaseViewModel;

public interface IViewModeControl<VM extends BaseViewModel> {

    /**
     * The class of the ViewModel to create an instance of it if it is not present.
     *
     * @return model class
     */
    Class<VM> getModelClass();

    /**
     * A ViewModel that is an instance of the given type {@code VM}.
     *
     * @return viewModel extends WM
     */
    VM obtainViewModel();

    /**
     * show common toast
     *
     * @param msg app info
     */
    void showToast(String msg);
}

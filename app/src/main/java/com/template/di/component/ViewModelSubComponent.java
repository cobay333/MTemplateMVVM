package com.template.di.component;

import com.template.feauture.home.MainViewModel;

import dagger.Subcomponent;

@Subcomponent
public interface ViewModelSubComponent {

    @Subcomponent.Builder
    interface Builder {
        ViewModelSubComponent build();
    }
    // list view model declaration
    MainViewModel mainViewModel();
}

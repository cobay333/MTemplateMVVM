package com.template.di.component;

import dagger.Subcomponent;

@Subcomponent
public interface ViewModelSubComponent {
    @Subcomponent.Builder
    interface Builder {
        ViewModelSubComponent build();
    }
    // list view model declaration
//    UserViewModel projectUserViewModel();
}

package com.template.di.component;

import android.app.Application;

import com.template.MyApplication;
import com.template.di.builder.ActivityBuilder;
import com.template.di.module.AppModule;
import com.template.di.module.ApplicationModule;
import com.template.di.module.HttpModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AppModule.class, ActivityBuilder.class,
        ApplicationModule.class, HttpModule.class, AndroidSupportInjectionModule.class})
public interface AppComponent extends AndroidInjector<MyApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}

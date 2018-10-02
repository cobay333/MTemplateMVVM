package com.template.di.builder;

import com.template.feauture.home.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

//    @ContributesAndroidInjector(modules = {
//            FeedActivityModule.class,
//            BlogFragmentProvider.class,
//            OpenSourceFragmentProvider.class})
//    abstract FeedActivity bindFeedActivity();
//
@ContributesAndroidInjector
abstract MainActivity bindMainActivity();
//
//    @ContributesAndroidInjector(modules = {
//            MainActivityModule.class,
//            AboutFragmentProvider.class,
//            RateUsDialogProvider.class})
//    abstract MainActivity bindMainActivity();
//
//    @ContributesAndroidInjector(modules = SplashActivityModule.class)
//    abstract SplashActivity bindSplashActivity();
}

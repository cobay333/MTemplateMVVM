package com.template.di.module;

import android.arch.lifecycle.ViewModelProvider;

import com.template.di.component.ViewModelSubComponent;
import com.template.utils.ViewModelFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(subcomponents = ViewModelSubComponent.class)
public class AppModule {

    @Singleton
    @Provides
    static ViewModelProvider.Factory provideViewModelFactory(
            ViewModelSubComponent.Builder viewModelSubComponent) {
        return new ViewModelFactory(viewModelSubComponent.build());
    }

//    @Provides
//    @Singleton
//    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
//        return appApiHelper;
//    }
//
//    @Provides
//    @ApiInfo
//    String provideApiKey() {
//        return BuildConfig.API_KEY;
//    }
//
//    @Provides
//    @Singleton
//    AppDatabase provideAppDatabase(@DatabaseInfo String dbName, Context context) {
//        return Room.databaseBuilder(context, AppDatabase.class, dbName).fallbackToDestructiveMigration()
//                .build();
//    }
//
//    @Provides
//    @Singleton
//    CalligraphyConfig provideCalligraphyDefaultConfig() {
//        return new CalligraphyConfig.Builder()
//                .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf")
//                .setFontAttrId(R.attr.fontPath)
//                .build();
//    }
//
//    @Provides
//    @Singleton
//    Context provideContext(Application application) {
//        return application;
//    }
//
//    @Provides
//    @Singleton
//    DataManager provideDataManager(AppDataManager appDataManager) {
//        return appDataManager;
//    }
//
//    @Provides
//    @DatabaseInfo
//    String provideDatabaseName() {
//        return AppConstants.DB_NAME;
//    }
//
//    @Provides
//    @Singleton
//    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
//        return appDbHelper;
//    }
//
//    @Provides
//    @Singleton
//    Gson provideGson() {
//        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
//    }
//
//    @Provides
//    @PreferenceInfo
//    String providePreferenceName() {
//        return AppConstants.PREF_NAME;
//    }
//
//    @Provides
//    @Singleton
//    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
//        return appPreferencesHelper;
//    }
//
//    @Provides
//    @Singleton
//    ApiHeader.ProtectedApiHeader provideProtectedApiHeader(@ApiInfo String apiKey,
//                                                           PreferencesHelper preferencesHelper) {
//        return new ApiHeader.ProtectedApiHeader(
//                apiKey,
//                preferencesHelper.getCurrentUserId(),
//                preferencesHelper.getAccessToken());
//    }
//
//    @Provides
//    SchedulerProvider provideSchedulerProvider() {
//        return new AppSchedulerProvider();
//    }
}
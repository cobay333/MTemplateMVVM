package com.template.di.module;

import android.app.Application;
import android.support.annotation.NonNull;
import android.util.Log;

import com.template.BuildConfig;
import com.template.data.remote.ApiService;
import com.template.data.remote.BaseIntercepter;
import com.template.data.remote.DataSourceInterface;
import com.template.data.remote.PersistentCookieStore;
import com.template.data.remote.RemoteDataSource;
import com.template.di.Remote;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public abstract class HttpModule {

    @Provides
    @Singleton
    static OkHttpClient.Builder provideOkHttpClickBuilder(Application application) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.writeTimeout(30, TimeUnit.SECONDS);
        builder.readTimeout(30, TimeUnit.SECONDS);
        builder.connectTimeout(30, TimeUnit.SECONDS);
        builder.cookieJar(new CookieJar() {
            private final PersistentCookieStore cookieStore = new PersistentCookieStore(application);

            @Override
            public void saveFromResponse(@NonNull HttpUrl url, @NonNull List<Cookie> cookies) {
                if (cookies.size() > 0) {
                    Log.d("HttpModule", "saveCookie:");
                    for (Cookie item : cookies) {
                        cookieStore.add(url, item);
                        if (item != null) {
                            Log.d("HttpModule", "cookie:" + item.toString());
                        }
                    }
                }
            }

            @Override
            public List<Cookie> loadForRequest(@NonNull HttpUrl url) {
                Log.d("HttpModule", "loadCookie:");
                List<Cookie> cookies = cookieStore.get(url);
                for (Cookie item : cookies) {
                    if (item != null) {
                        Log.d("HttpModule", "cookie:" + item.toString());
                    }
                }
                return cookies;
            }
        });
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(interceptor);
        }
        return builder;
    }

    @Provides
    @Singleton
    static Retrofit.Builder provideRetrofitBuilder() {
        return new Retrofit.Builder();
    }

    @Provides
    @Singleton
    static Retrofit provideRetrofit(@NonNull Retrofit.Builder builder, @NonNull OkHttpClient.Builder client) {
        client.addInterceptor(new BaseIntercepter());
        OkHttpClient httpClient = client.build();

        builder.client(httpClient);
        builder.baseUrl(BuildConfig.BASE_URL);
        builder.addConverterFactory(GsonConverterFactory.create());
        return builder.build();
    }

    @Provides
    @Singleton
    static ApiService provideTraderService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }

    @Singleton
    @Binds
    @Remote
    abstract DataSourceInterface provideTraderRemoteDataSource(RemoteDataSource dataSource);

}

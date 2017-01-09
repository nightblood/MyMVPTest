package com.zlf.mytest.di.module;

import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;

/**
 * Created by zlf on 2017/1/9.
 */
@Module
public class GlobalConfigModule {

    private HttpUrl mUrl;
    private List<Interceptor> mInterceptors;

    public GlobalConfigModule(HttpUrl url) {
        mUrl = url;
    }

    @Singleton
    @Provides
    HttpUrl provideHttpUrl() {
        return mUrl;
    }

    @Singleton
    @Provides
    List<Interceptor> provideInterceptors() {
        return mInterceptors;
    }
}

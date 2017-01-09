package com.zlf.mytest.di.module;

import android.app.Application;

import com.zlf.mytest.http.RequestIntercept;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zlf on 2017/1/9.
 * 提供网络相关工具
 * Retrofit, OkHttpClient,
 */
@Module
public class ClientModule {
    private static final long TIME_OUT = 10l;
    private static final long HTTP_RESPONSE_DISK_CACHE_MAX_SIZE = 10 * 1024 * 1024;

    private Application mApplication;

    public ClientModule(Application application) {
        this.mApplication = application;

    }

    // HttpUrl 的实现由GlobalConfigModule提供,因为 GlobalConfigModule保存了url (基本数据都保存在 GlobalConfigModule中)
    @Singleton
    @Provides
    Retrofit provideRetrofit(Retrofit.Builder builder, OkHttpClient client, HttpUrl httpUrl) {
        return builder.baseUrl(httpUrl)
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    Retrofit.Builder provideRetrofitBuilder() {
        return new Retrofit.Builder();
    }

    @Singleton
    @Provides
    OkHttpClient.Builder provideOkHttpUrlBuilder() {
        return new OkHttpClient.Builder();
    }

    @Singleton
    @Provides
    OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder, Cache cache, Interceptor interceptor
    , List<Interceptor> interceptors) {
        OkHttpClient.Builder builder1 = builder.connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .cache(cache)
                .addNetworkInterceptor(interceptor);

        if (interceptors != null && interceptors.size() > 0) {
            for (Interceptor item : interceptors) {
                builder1.addNetworkInterceptor(item);
            }
        }
        return builder1.build();
    }

    @Singleton
    @Provides
    Cache provideCache(File cacheFile) {
        return new Cache(cacheFile, HTTP_RESPONSE_DISK_CACHE_MAX_SIZE);
    }

    @Singleton
    @Provides
    Interceptor provideInterceptor(RequestIntercept intercept) {
        return intercept;
    }

}

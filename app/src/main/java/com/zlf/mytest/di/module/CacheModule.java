package com.zlf.mytest.di.module;

import com.zlf.mytest.mvp.api.CommonCache;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.rx_cache.internal.RxCache;

/**
 * Created by zlf on 2017/1/9.
 */
@Module
public class CacheModule {

    @Singleton
    @Provides
    CommonCache provideCommonCache(RxCache rxCache) {
        return rxCache.using(CommonCache.class);
    }
}

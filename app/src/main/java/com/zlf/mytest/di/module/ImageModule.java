package com.zlf.mytest.di.module;

import com.zlf.mytest.utils.imageutil.BaseImageLoaderStraterge;
import com.zlf.mytest.utils.imageutil.GlideImageLoaderStratege;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zlf on 2017/1/9.
 */
@Module
public class ImageModule {

    @Singleton
    @Provides
    BaseImageLoaderStraterge provideImageLoaderStrategy(GlideImageLoaderStratege glideImageLoaderStratege) {
        return glideImageLoaderStratege;
    }
}

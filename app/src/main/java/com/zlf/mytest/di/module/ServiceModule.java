package com.zlf.mytest.di.module;

import com.zlf.mytest.di.retrofitservice.CommonService;
import com.zlf.mytest.di.retrofitservice.UserService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by zlf on 2017/1/9.
 */
@Module
public class ServiceModule {

    @Singleton
    @Provides
    CommonService provideCommService(Retrofit retrofit) {
        return retrofit.create(CommonService.class);
    }

    @Singleton
    @Provides
    UserService provideUserService(Retrofit retrofit) {
        return retrofit.create(UserService.class);
    }
}

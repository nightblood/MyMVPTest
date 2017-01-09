package com.zlf.mytest.di.component;

import com.zlf.mytest.di.module.AppModule;
import com.zlf.mytest.di.module.CacheModule;
import com.zlf.mytest.di.module.ClientModule;
import com.zlf.mytest.di.module.GlobalConfigModule;
import com.zlf.mytest.di.module.ImageModule;
import com.zlf.mytest.di.module.ServiceModule;

import dagger.Component;

/**
 * Created by zlf on 2017/1/9.
 * AppModule:
 * ClientModule:
 * ServiceModule:
 * ImageModule:
 * CacheModule:
 * GlobeConfigModule
 *
 */
@Component(modules = {AppModule.class, ClientModule.class, ServiceModule.class, GlobalConfigModule.class
, ImageModule.class, CacheModule.class})
public interface AppComponent {


}

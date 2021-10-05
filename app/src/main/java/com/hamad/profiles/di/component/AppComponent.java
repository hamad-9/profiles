package com.hamad.profiles.di.component;

import android.app.Application;
import com.hamad.profiles.MvvmApp;
import com.hamad.profiles.data.DataManager;

import com.hamad.profiles.di.module.AppModule;
import com.hamad.profiles.utils.rx.SchedulerProvider;

import dagger.BindsInstance;
import dagger.Component;

import javax.inject.Singleton;


@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(MvvmApp app);

    DataManager getDataManager();

    SchedulerProvider getSchedulerProvider();

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}

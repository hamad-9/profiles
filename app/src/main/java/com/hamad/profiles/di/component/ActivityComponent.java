package com.hamad.profiles.di.component;

import com.hamad.profiles.di.module.ActivityModule;
import com.hamad.profiles.di.scope.ActivityScope;

import com.hamad.profiles.ui.login.LoginActivity;
import com.hamad.profiles.ui.main.MainActivity;
import com.hamad.profiles.ui.splash.SplashActivity;

import dagger.Component;


@ActivityScope
@Component(modules = ActivityModule.class, dependencies = AppComponent.class)
public interface ActivityComponent {



    void inject(LoginActivity activity);

    void inject(MainActivity activity);

    void inject(SplashActivity splashActivity);

}

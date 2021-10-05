package com.hamad.profiles.di.component;

import com.hamad.profiles.di.module.FragmentModule;
import com.hamad.profiles.di.scope.FragmentScope;
import dagger.Component;

@FragmentScope
@Component(modules = FragmentModule.class, dependencies = AppComponent.class)
public interface FragmentComponent {

}

package com.hamad.profiles.di.module;


import androidx.recyclerview.widget.LinearLayoutManager;

import com.hamad.profiles.ui.base.BaseFragment;


import dagger.Module;
import dagger.Provides;

@Module
public class FragmentModule {

    private BaseFragment<?, ?> fragment;

    public FragmentModule(BaseFragment<?, ?> fragment) {
        this.fragment = fragment;
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager() {
        return new LinearLayoutManager(fragment.getActivity());
    }



}

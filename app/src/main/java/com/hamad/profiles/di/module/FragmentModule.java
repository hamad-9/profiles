package com.hamad.profiles.di.module;


import androidx.core.util.Supplier;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.hamad.profiles.ViewModelProviderFactory;
import com.hamad.profiles.data.DataManager;
import com.hamad.profiles.ui.base.BaseFragment;
import com.hamad.profiles.ui.main.profile.ProfileViewModel;
import com.hamad.profiles.utils.rx.SchedulerProvider;


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

    @Provides
    ProfileViewModel provideProfileViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        Supplier<ProfileViewModel> supplier = () -> new ProfileViewModel(dataManager, schedulerProvider);
        ViewModelProviderFactory<ProfileViewModel> factory = new ViewModelProviderFactory<>(ProfileViewModel.class, supplier);
        return new ViewModelProvider(fragment, factory).get(ProfileViewModel.class);
    }

}

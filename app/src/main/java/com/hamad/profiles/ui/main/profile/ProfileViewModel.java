package com.hamad.profiles.ui.main.profile;

import androidx.lifecycle.ViewModel;

import com.hamad.profiles.data.DataManager;
import com.hamad.profiles.ui.base.BaseViewModel;
import com.hamad.profiles.utils.rx.SchedulerProvider;

public class ProfileViewModel extends BaseViewModel<ProfileNavigator> {
    public ProfileViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }


    public void onNavBackClick() {
        getNavigator().goBack();
    }

}
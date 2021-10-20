package com.hamad.profiles.ui.main.profile;
import com.hamad.profiles.data.DataManager;
import com.hamad.profiles.data.model.api.ProfileResponse;
import com.hamad.profiles.ui.base.BaseViewModel;
import com.hamad.profiles.utils.rx.SchedulerProvider;




public class ProfileViewModel extends BaseViewModel<ProfileNavigator> {

    public ProfileResponse profileResponse;
    public String Image1;
    public String Image2;
    public String Image3;
    public String gender;


    public ProfileViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }
    public void onNavBackClick() {
        getNavigator().goBack();
    }




}
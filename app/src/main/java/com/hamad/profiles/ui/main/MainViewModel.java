package com.hamad.profiles.ui.main;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import android.text.TextUtils;
import android.util.Log;

import com.hamad.profiles.data.DataManager;
import com.hamad.profiles.data.model.api.ProfileResponse;
import com.hamad.profiles.ui.base.BaseViewModel;
import com.hamad.profiles.utils.rx.SchedulerProvider;

import java.util.ArrayList;
import java.util.List;


public class MainViewModel extends BaseViewModel<MainNavigator> {

    private static final String TAG = "MainViewModel";

    public static final int NO_ACTION = -1, ACTION_ADD_ALL = 0, ACTION_DELETE_SINGLE = 1;

    private final ObservableField<String> appVersion = new ObservableField<>();

    private final ObservableField<String> userEmail = new ObservableField<>();

    private final ObservableField<String> userName = new ObservableField<>();

    private final ObservableField<String> userProfilePicUrl = new ObservableField<>();

    private int action = NO_ACTION;

    private final MutableLiveData<List<ProfileResponse>> ProfileListLiveData;


    public MainViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        ProfileListLiveData = new MutableLiveData<>();
        fetchProfiles();
    }

    public ObservableField<String> getAppVersion() {
        return appVersion;
    }

    public void logout() {
        Log.d(TAG, "logout: i'm here");
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager().doLogoutApiCall()
                .doOnSuccess(response -> getDataManager().setUserAsLoggedOut())
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {
                    setIsLoading(false);
                    getNavigator().openLoginActivity();
                }, throwable -> {
                    setIsLoading(false);
                    Log.d(TAG, "logout: hamad Error");
                    getNavigator().handleError(throwable);
                }));
    }

    public void onNavMenuCreated() {
        final String currentUserName = getDataManager().getCurrentUserName();
        if (!TextUtils.isEmpty(currentUserName)) {
            userName.set(currentUserName);
        }

        final String currentUserEmail = getDataManager().getCurrentUserEmail();
        if (!TextUtils.isEmpty(currentUserEmail)) {
            userEmail.set(currentUserEmail);
        }

        final String profilePicUrl = getDataManager().getCurrentUserProfilePicUrl();
        if (!TextUtils.isEmpty(profilePicUrl)) {
            userProfilePicUrl.set(profilePicUrl);
        }
    }

    public void updateAppVersion(String version) {
        appVersion.set(version);
    }


    //------------------------------------------------------------------------------------------------
    public void fetchProfiles() {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .getProfileApiCall()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(profileResponse -> {
                    if (profileResponse != null ) {
                        ArrayList<ProfileResponse> arrayList = new ArrayList();
                        arrayList.addAll(profileResponse);
                        getNavigator().updateList(arrayList);
                    }
                    setIsLoading(false);
                }, throwable -> {
                    setIsLoading(false);
                    getNavigator().handleError(throwable);
                }));

    }

    //------------------------------------------------------------------------------------------------

}

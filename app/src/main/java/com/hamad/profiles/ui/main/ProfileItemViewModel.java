package com.hamad.profiles.ui.main;

import androidx.databinding.ObservableField;

import com.hamad.profiles.data.model.api.ProfileResponse;

public class ProfileItemViewModel {

    private static final String TAG = "ProfileItemViewModel";
    public final ObservableField<String> imageUrl;
    public final ObservableField<String> firstName;
    public final ObservableField<String> lastName;
    public final ObservableField<String> fullName;
    public final ObservableField<String> email;
    public final ObservableField<String> mobileNumber;
    public final ProfileItemViewModelListener mListener;
    private final ProfileResponse mProfile;


    public ProfileItemViewModel(ProfileResponse profile, ProfileItemViewModelListener listener) {
        this.mProfile = profile;
        this.mListener = listener;


        imageUrl = new ObservableField<>(mProfile.getAvatar());
        firstName = new ObservableField<>(mProfile.getFirstName());
        lastName = new ObservableField<>(mProfile.getLastName());
        fullName = new ObservableField<>(mProfile.getFullName());
        mobileNumber = new ObservableField<>(mProfile.getMobileNumber());
        email = new ObservableField<>(mProfile.getEmail());
    }

    public void onItemClick() {
        mListener.onItemClick(this.mProfile);
    }

    public interface ProfileItemViewModelListener {
        void onItemClick(ProfileResponse profile);
    }

}

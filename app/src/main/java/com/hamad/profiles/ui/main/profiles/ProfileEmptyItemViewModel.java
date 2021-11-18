package com.hamad.profiles.ui.main.profiles;

public class ProfileEmptyItemViewModel {

    private ProfileEmptyItemViewModelListener mListener;

    public ProfileEmptyItemViewModel(ProfileEmptyItemViewModelListener listener) {
        this.mListener = listener;
    }

    public void onRetryClick() {
        mListener.onRetryClick();
    }

    public interface ProfileEmptyItemViewModelListener {

        void onRetryClick();
    }
}

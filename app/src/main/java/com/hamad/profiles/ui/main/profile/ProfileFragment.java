package com.hamad.profiles.ui.main.profile;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hamad.profiles.BR;
import com.hamad.profiles.R;
import com.hamad.profiles.data.model.api.ProfileResponse;
import com.hamad.profiles.databinding.ProfileFragmentBinding;
import com.hamad.profiles.di.component.FragmentComponent;
import com.hamad.profiles.ui.base.BaseFragment;

public class ProfileFragment extends BaseFragment<ProfileFragmentBinding, ProfileViewModel> implements ProfileNavigator {

    public static final String TAG = "ProfileFragment";



    public static ProfileFragment newInstance(ProfileResponse profile) {
        Bundle args = new Bundle();
        args.putSerializable("profile", profile);
        ProfileFragment fragment = new ProfileFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.profile_fragment;

    }

    @Override
    public void goBack() {
        getBaseActivity().onFragmentDetached(TAG);
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel.setNavigator(this);
        ProfileResponse profileResponse = (ProfileResponse) getArguments().getSerializable("profile");
        Log.d(TAG, "onCreate: done");
        mViewModel.profileResponse = profileResponse;
        mViewModel.Image1=profileResponse.getPics()[0];
        mViewModel.Image2=profileResponse.getPics()[1];
        mViewModel.Image3=profileResponse.getPics()[2];

        if (profileResponse.getGender() == "M") {
            mViewModel.gender = "Gender: Male";
        } else {
            mViewModel.gender = "Gender: female";
        }
    }


    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }




}
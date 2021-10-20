package com.hamad.profiles.ui.main.profile;

import androidx.databinding.library.baseAdapters.BR;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hamad.profiles.R;
import com.hamad.profiles.data.model.api.ProfileResponse;
import com.hamad.profiles.databinding.ProfileFragmentBinding;
import com.hamad.profiles.di.component.FragmentComponent;
import com.hamad.profiles.ui.base.BaseFragment;

public class ProfileFragment extends BaseFragment<ProfileFragmentBinding, ProfileViewModel> implements ProfileNavigator {

    public static final String TAG = "ProfileFragment";



    public static ProfileFragment newInstance() {
        Bundle args = new Bundle();
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



//    public void setUpViewModel(){
//        if (this.getArguments() != null) {
//            mViewModel.setPosition(this.getArguments().getInt("position"));
//        }
//    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel.setNavigator(this);
    }


    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }




}
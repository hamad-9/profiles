package com.hamad.profiles.ui.main;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.hamad.profiles.data.model.api.ProfileResponse;
import com.hamad.profiles.databinding.ItemProfileEmptyViewBinding;
import com.hamad.profiles.databinding.ItemProfileViewBinding;
import com.hamad.profiles.ui.base.BaseViewHolder;
import com.hamad.profiles.utils.AppLogger;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ProfileAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private static final String TAG = "MainAdapter";

    public static final int VIEW_TYPE_EMPTY = 0;

    public static final int VIEW_TYPE_NORMAL = 1;

    private List<ProfileResponse> mProfileResponseList;

    private MainAdapterListener mListener;

    @Inject
    public ProfileAdapter(ArrayList<ProfileResponse> mProfileResponseList) {
        this.mProfileResponseList = mProfileResponseList;
    }

    //-----------------------------------------------------------------------------------------------------------------
    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {

            case VIEW_TYPE_NORMAL:
                ItemProfileViewBinding profileViewBinding = ItemProfileViewBinding.inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);
                return new ProfileViewHolder(profileViewBinding);

            case VIEW_TYPE_EMPTY:

            default:
                ItemProfileEmptyViewBinding emptyViewBinding = ItemProfileEmptyViewBinding.inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);
                return new EmptyViewHolder(emptyViewBinding);

        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        if (mProfileResponseList != null && mProfileResponseList.size() > 0) {
            return mProfileResponseList.size();
        } else {
            return 1;
        }
    }

    public void updateList(ArrayList<ProfileResponse> users) {
        if (mProfileResponseList == null)
            mProfileResponseList = new ArrayList<>() ;

        mProfileResponseList.clear();
        mProfileResponseList.addAll(users);
        notifyDataSetChanged();

    }

    public class ProfileViewHolder extends BaseViewHolder implements ProfileItemViewModel.ProfileItemViewModelListener {

        private ItemProfileViewBinding mBinding;

        private ProfileItemViewModel mProfileItemViewModel;

        public ProfileViewHolder(ItemProfileViewBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            final ProfileResponse profile = mProfileResponseList.get(position);
            mProfileItemViewModel = new ProfileItemViewModel(profile, this);
            mBinding.setViewModel(mProfileItemViewModel);
            mBinding.executePendingBindings();
        }

        @Override
        public void onItemClick(String firstName) {

            Log.d(TAG, "hana saif: " + firstName);

//            if (firstName != null) {
//                try {
//                    Intent intent = new Intent();
//                    intent.setAction(Intent.ACTION_VIEW);
//                    intent.addCategory(Intent.CATEGORY_BROWSABLE);
//                    intent.setData(Uri.parse(firstName));
//                    itemView.getContext().startActivity(intent);
//                } catch (Exception e) {
//                    AppLogger.d("firstName error");
//                }
//            }
        }
    }

    //-----------------------------------------------------------------------------------------------------------------

    @Override
    public int getItemViewType(int position) {
        if (mProfileResponseList != null && !mProfileResponseList.isEmpty()) {
            return VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_EMPTY;
        }
    }

    public interface MainAdapterListener {
        void onRetryClick();
    }



    public class EmptyViewHolder extends BaseViewHolder implements ProfileEmptyItemViewModel.ProfileEmptyItemViewModelListener {

        private ItemProfileEmptyViewBinding mBinding;

        public EmptyViewHolder(ItemProfileEmptyViewBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            ProfileEmptyItemViewModel emptyItemViewModel = new ProfileEmptyItemViewModel(this);
            mBinding.setViewModel(emptyItemViewModel);
        }

        @Override
        public void onRetryClick() {
            mListener.onRetryClick();
        }
    }
}

package com.hamad.profiles.ui.splash;

import android.content.Intent;
import android.os.Bundle;

import com.hamad.profiles.BR;
import com.hamad.profiles.R;
import com.hamad.profiles.databinding.ActivitySplashBinding;
import com.hamad.profiles.di.component.ActivityComponent;
import com.hamad.profiles.ui.base.BaseActivity;
import com.hamad.profiles.ui.login.LoginActivity;
import com.hamad.profiles.ui.main.MainActivity;



public class SplashActivity extends BaseActivity<ActivitySplashBinding, SplashViewModel> implements SplashNavigator {

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void openLoginActivity() {
        Intent intent = LoginActivity.newIntent(SplashActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    public void openMainActivity() {
        Intent intent = MainActivity.newIntent(SplashActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel.setNavigator(this);
        mViewModel.startSeeding();
    }

    @Override
    public void performDependencyInjection(ActivityComponent buildComponent) {
        buildComponent.inject(this);
    }
}

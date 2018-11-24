package com.ntd.englishconversation.screen.profileuser;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import com.ntd.englishconversation.BaseActivity;
import com.ntd.englishconversation.R;
import com.ntd.englishconversation.data.model.UserModel;
import com.ntd.englishconversation.databinding.ActivityProfileUserBinding;

import static com.ntd.englishconversation.utils.Constant.EXTRA_USER;

/**
 * Profileuser Screen.
 */
public class ProfileUserActivity extends BaseActivity {

    private ProfileUserContract.ViewModel mViewModel;

    public static Intent getInstance(Context context, UserModel userModel) {
        Intent intent = new Intent(context, ProfileUserActivity.class);
        intent.putExtra(EXTRA_USER, userModel);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        UserModel userModel = getIntent().getParcelableExtra(EXTRA_USER);
        mViewModel = new ProfileUserViewModel(this, userModel, getSupportFragmentManager());
        ProfileUserContract.Presenter presenter = new ProfileUserPresenter(mViewModel);
        mViewModel.setPresenter(presenter);
        ActivityProfileUserBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_profile_user);
        binding.setViewModel((ProfileUserViewModel) mViewModel);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mViewModel.onStart();
    }

    @Override
    protected void onStop() {
        mViewModel.onStop();
        super.onStop();
    }
}

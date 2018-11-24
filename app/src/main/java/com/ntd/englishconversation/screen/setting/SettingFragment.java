package com.ntd.englishconversation.screen.setting;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ntd.englishconversation.R;
import com.ntd.englishconversation.data.source.SettingRepository;
import com.ntd.englishconversation.data.source.local.setting.SettingLocalDataSource;
import com.ntd.englishconversation.data.source.local.sharedprf.SharedPrefsImpl;
import com.ntd.englishconversation.data.source.remote.auth.AuthenicationRemoteDataSource;
import com.ntd.englishconversation.data.source.remote.auth.AuthenicationRepository;
import com.ntd.englishconversation.databinding.FragmentSettingBinding;
import com.ntd.englishconversation.screen.main.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends Fragment {
    private SettingContract.ViewModel mViewModel;

    public static SettingFragment newInstance() {
        return new SettingFragment();
    }

    public SettingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mViewModel = new SettingViewModel((MainActivity) getActivity());

        AuthenicationRepository authenicationRepository =
                new AuthenicationRepository(new AuthenicationRemoteDataSource());
        SettingRepository settingRepository =
                new SettingRepository(
                        new SettingLocalDataSource(new SharedPrefsImpl(getContext())));
        SettingContract.Presenter presenter = new SettingPresenter(
                mViewModel,
                authenicationRepository,
                settingRepository);

        mViewModel.setPresenter(presenter);

        FragmentSettingBinding binding = DataBindingUtil
                .inflate(inflater,
                        R.layout.fragment_setting,
                        container,
                        false);
        binding.setViewModel((SettingViewModel) mViewModel);
        return binding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
        mViewModel.onStart();
    }

    @Override
    public void onStop() {
        mViewModel.onStop();
        super.onStop();
    }
}

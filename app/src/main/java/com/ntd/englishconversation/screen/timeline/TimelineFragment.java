package com.ntd.englishconversation.screen.timeline;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ntd.englishconversation.BaseFragment;
import com.ntd.englishconversation.R;
import com.ntd.englishconversation.databinding.FragmentTimelineBinding;
import com.ntd.englishconversation.utils.navigator.Navigator;

/**
 * Timeline Screen.
 */
public abstract class TimelineFragment extends BaseFragment {

    private TimelineContract.ViewModel mViewModel;

    protected abstract TimelineContract.Presenter getPresenter(
            TimelineContract.ViewModel viewModel);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewModel = new TimelineViewModel(getContext(), new Navigator(getActivity()));
        mViewModel.setPresenter(getPresenter(mViewModel));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        FragmentTimelineBinding binding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_timeline, container, false);
        binding.setViewModel((TimelineViewModel) mViewModel);
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

    @Override
    public void onDestroy() {
        mViewModel.onDestroy();
        super.onDestroy();
    }
}

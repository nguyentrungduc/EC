package com.ntd.englishconversation.screen.videoDetail;

import com.ntd.englishconversation.BasePresenter;
import com.ntd.englishconversation.BaseViewModel;

/**
 * This specifies the contract between the view and the presenter.
 */
interface VideoDetailContract {
    /**
     * View.
     */
    interface ViewModel extends BaseViewModel<Presenter> {
        void onPause();

        void onResume();

        void finishActivity();
    }

    /**
     * Presenter.
     */
    interface Presenter extends BasePresenter {
        void onPause();

        void onResume();
    }
}

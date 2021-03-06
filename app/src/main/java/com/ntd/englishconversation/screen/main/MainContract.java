package com.ntd.englishconversation.screen.main;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseUser;
import com.ntd.englishconversation.BasePresenter;
import com.ntd.englishconversation.BaseViewModel;

/**
 * This specifies the contract between the view and the presenter.
 */
interface MainContract {
    /**
     * View.
     */
    interface ViewModel extends BaseViewModel<Presenter> {
        void onGetCurrentUserSuccess(FirebaseUser data);

        void onSignOutClick();

        void onSignOutSuccess();

        void onSignOutFailed(String msg);

        GoogleApiClient getGoogleApiClient();
    }

    /**
     * Presenter.
     */
    interface Presenter extends BasePresenter {
        void signOut();
    }
}

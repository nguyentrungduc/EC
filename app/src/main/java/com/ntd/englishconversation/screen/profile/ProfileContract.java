package com.ntd.englishconversation.screen.profile;

import com.ntd.englishconversation.BasePresenter;
import com.ntd.englishconversation.BaseViewModel;
import com.ntd.englishconversation.data.model.UserModel;

;

/**
 * This specifies the contract between the view and the presenter.
 */
interface ProfileContract {
    /**
     * View.
     */
    interface ViewModel extends BaseViewModel<Presenter> {
        void onGetUserSuccesss(UserModel data);

        void onChangeAvtClick();

        void onEditUserClick();

        void showChangePasswordDialog();
    }

    /**
     * Presenter.
     */
    interface Presenter extends BasePresenter {
    }
}

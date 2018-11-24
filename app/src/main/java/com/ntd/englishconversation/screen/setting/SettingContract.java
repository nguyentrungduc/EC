package com.ntd.englishconversation.screen.setting;

/**
 * Created by doan.van.toan on 1/16/18.
 */

import com.ntd.englishconversation.BasePresenter;
import com.ntd.englishconversation.BaseViewModel;
import com.ntd.englishconversation.data.model.Setting;
import com.ntd.englishconversation.data.model.UserModel;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Define contract of SettingViewModel and SettingPresneter
 */
public interface SettingContract {
    /**
     * Setting ViewModel
     */
    interface ViewModel extends BaseViewModel<Presenter> {
        void onSignOutSuccess();

        void onSignOutFailed(String msg);

        void onGetCurrentUserSuccess(UserModel userModel);

        void onGetUserFailed(String msg);

        GoogleApiClient getGoogleApiCliennt();

        void onGetSettingSuccess(Setting setting);

        void setAllowChangePassword(boolean b);
    }

    /**
     * Setting Presenter
     */
    interface Presenter extends BasePresenter {
        void signOut();

        void getSetting();

        void saveSetting(Setting setting);
    }
}

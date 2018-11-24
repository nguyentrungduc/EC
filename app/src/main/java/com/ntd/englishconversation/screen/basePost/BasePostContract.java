package com.ntd.englishconversation.screen.basePost;

import android.content.Intent;

import com.ntd.englishconversation.BasePresenter;
import com.ntd.englishconversation.BaseViewModel;
import com.ntd.englishconversation.data.model.MediaModel;
import com.ntd.englishconversation.data.model.TimelineModel;
import com.ntd.englishconversation.data.model.UserModel;

import java.util.List;

/**
 * Created by Sony on 2/2/2018.
 */

public interface BasePostContract {
    interface ViewModel extends BaseViewModel<Presenter> {

        void onPause();

        void onActivityResult(int requestCode, int resultCode, Intent data);

        void onGetCurrentUserSuccess(UserModel data);

        void onGetCurrentUserFailed(String msg);

        void onImagePickerClick();

        void onPlacePickerClick();

        void onSubmitPost();

        void uploadFiles(List<MediaModel> mediaModels);

        void onSubmitPostSuccess();

        void onSubmitPostFailed(String msg);

        void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults);

        void onDestroy();

    }

    /**
     * Presenter.
     */
    interface Presenter extends BasePresenter {
        void getUser();

        void submitPost(TimelineModel timelineModel);

        void onDestroy();
    }
}

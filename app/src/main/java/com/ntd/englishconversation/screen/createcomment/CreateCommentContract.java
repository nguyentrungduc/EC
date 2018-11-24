package com.ntd.englishconversation.screen.createcomment;

import android.content.Intent;
import android.widget.PopupMenu;

import com.darsh.multipleimageselect.models.Image;
import com.ntd.englishconversation.BasePresenter;
import com.ntd.englishconversation.BaseViewModel;
import com.ntd.englishconversation.data.model.Comment;
import com.ntd.englishconversation.data.model.MediaModel;
import com.ntd.englishconversation.data.model.UserModel;
import com.ntd.englishconversation.screen.comment.CallBack;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface CreateCommentContract {
    /**
     * View.
     */
    interface ViewModel extends BaseViewModel<Presenter> {
        void onPause();

        void onResume();

        void showToast(int stringId);

        void onGetMultimediaDataDone(Intent intent, @MediaModel.MediaType int type);

        void onMultimediaFileAttached(MediaModel mediaModel);

        void onPostLiteralCommentSuccess(Comment comment);

        void onPostLiteralCommentFailure(String message);

        void onDestroy();

        void setPopUpMenu(PopupMenu popUpMenu);

        void onGetCurrentUserSuccess(UserModel data);

        void onGetCurrentUserFailed(String msg);

        void setListener(CallBack callBack);

        void replaceFragment();
    }

    /**
     * Presenter.
     */
    interface Presenter extends BasePresenter {
        void onPause();

        void onResume();

        void onMultimediaMenuItemClick(int type);

        void onRecordVideoDone(String uri, @MediaModel.MediaType int type);

        void onImageSelectDone(Image image);

        void onDeleteItemMediaClicked();

        void postLiteralComment(Comment comment);

        void updateLiteralComment(Comment commentNew, Comment commentOld);

        void onSelectedAudioSuccess(String filePath, String fileName);

        void onDestroy();
    }
}

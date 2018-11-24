package com.ntd.englishconversation.screen.dialog;

import com.ntd.englishconversation.BasePresenter;
import com.ntd.englishconversation.BaseViewModel;
import com.ntd.englishconversation.data.model.TimelineModel;

/**
 * Created by Sony on 1/25/2018.
 */

public interface OptionPostContract {
    /**
     * base presenter for ConversationDetailPresenter
     */
    interface Presenter extends BasePresenter {
        void deletePost(TimelineModel timelineModel);

        void editPost(TimelineModel timelineModel);
    }

    /**
     * base presenter for ConversationDetailViewModel
     */
    interface ViewModel extends BaseViewModel<OptionPostContract.Presenter> {

        void onClickDeletePost();

        void onClickEditPost();

        void showConfirmDeleteDialog();

    }
}

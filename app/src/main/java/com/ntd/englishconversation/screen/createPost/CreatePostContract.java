package com.ntd.englishconversation.screen.createPost;

import com.ntd.englishconversation.screen.basePost.BasePostContract;

/**
 * This specifies the contract between the view and the presenter.
 */
interface CreatePostContract {
    /**
     * View.
     */
    interface ViewModel extends BasePostContract.ViewModel {

    }

    /**
     * Presenter.
     */
    interface Presenter extends BasePostContract.Presenter {

    }
}

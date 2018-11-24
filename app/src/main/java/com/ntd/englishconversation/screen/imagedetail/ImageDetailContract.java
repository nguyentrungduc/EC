package com.ntd.englishconversation.screen.imagedetail;

import com.ntd.englishconversation.BasePresenter;
import com.ntd.englishconversation.BaseViewModel;

/**
 * This specifies the contract between the view and the presenter.
 */
interface ImageDetailContract {
    /**
     * View.
     */
    interface ViewModel extends BaseViewModel<Presenter> {
    }

    /**
     * Presenter.
     */
    interface Presenter extends BasePresenter {
    }
}

package com.ntd.englishconversation.screen.selectedimagedetail;

import com.ntd.englishconversation.BasePresenter;
import com.ntd.englishconversation.BaseViewModel;

/**
 * This specifies the contract between the view and the presenter.
 */
interface SelectedImageDetailContract {
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

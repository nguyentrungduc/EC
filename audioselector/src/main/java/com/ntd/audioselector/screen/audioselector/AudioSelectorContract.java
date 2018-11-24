package com.ntd.audioselector.screen.audioselector;

import com.ntd.audioselector.BasePresenter;
import com.ntd.audioselector.BaseViewModel;

/**
 * Created by fs-sournary.
 * Data: 1/19/18.
 * Description:
 */

public interface AudioSelectorContract {

    /**
     * Presenter for AudioSelectorPresenter
     */
    interface Presenter extends BasePresenter {

    }

    /**
     * ViewModel for AudioSelectorViewModel
     */
    interface ViewModel extends BaseViewModel<Presenter> {

    }
}

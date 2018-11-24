package com.ntd.audioselector.widget.dialog.recording;

import com.ntd.audioselector.BasePresenter;
import com.ntd.audioselector.BaseViewModel;

/**
 * Created by fs-sournary.
 * Data: 1/19/18.
 * Description:
 */

public interface RecordingContract {

    /**
     * Presenter for RecordingPresenter
     */
    interface Presenter extends BasePresenter {

    }

    /**
     * ViewModel for RecordingViewModel
     */
    interface ViewModel extends BaseViewModel<Presenter> {

        boolean isCancelClick();

        void initRecord(String filePath);
    }
}

package com.ntd.englishconversation.screen.editPost;

import android.app.Activity;

import com.ntd.englishconversation.data.model.TimelineModel;
import com.ntd.englishconversation.screen.basePost.BasePostViewModel;
import com.ntd.englishconversation.utils.navigator.Navigator;

/**
 * Created by Sony on 2/2/2018.
 */

public class EditPostViewModel extends BasePostViewModel implements EditPostContract.ViewModel{

    public EditPostViewModel(Activity activity, Navigator navigator) {
        super(activity, navigator);
    }

    public EditPostViewModel(Activity activity, Navigator navigator, TimelineModel timelineModel) {
        super(activity, navigator, timelineModel);
    }

}

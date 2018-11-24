package com.ntd.englishconversation.screen.timeline.editorchoise;

import com.ntd.englishconversation.data.model.TimelineModel;
import com.ntd.englishconversation.data.source.SettingRepository;
import com.ntd.englishconversation.data.source.remote.auth.AuthenicationRepository;
import com.ntd.englishconversation.data.source.remote.timeline.TimelineRepository;
import com.ntd.englishconversation.screen.timeline.TimelineContract;
import com.ntd.englishconversation.screen.timeline.TimelinePresenter;
import com.ntd.englishconversation.screen.timeline.TimelineViewModel;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by doan.van.toan on 2/8/18.
 */

public class EditorChoiseTimelinePresenter extends TimelinePresenter {

    /**
     * DO NOT allow user to create new post in home timeline
     */
    @Override
    protected void initAllowCreatePost() {
        ((TimelineViewModel) mViewModel).setAllowCreatePost(false);
    }

    public EditorChoiseTimelinePresenter(TimelineContract.ViewModel viewModel,
                                         AuthenicationRepository authenicationRepository,
                                         TimelineRepository timelineRepository,
                                         SettingRepository settingRepository) {
        super(viewModel, authenicationRepository, timelineRepository, settingRepository);
    }

    @Override
    public void getTimelineData(TimelineModel lastTimelineModel) {
        Observable<List<TimelineModel>> observable =
                mTimelineRepository.getEditorChoiseTimeline(lastTimelineModel);

        mDisposable.add(observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<List<TimelineModel>>() {
                    @Override
                    public void onNext(List<TimelineModel> timelineModels) {
                        mViewModel.onGetTimelinesSuccess(timelineModels);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mViewModel.onGetTimelinesFailure(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                    }
                }));
    }

}

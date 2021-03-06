package com.ntd.englishconversation.screen.createcomment;

import android.text.TextUtils;

import com.darsh.multipleimageselect.models.Image;
import com.ntd.englishconversation.data.model.Comment;
import com.ntd.englishconversation.data.model.MediaModel;
import com.ntd.englishconversation.data.model.UserModel;
import com.ntd.englishconversation.data.source.callback.DataCallback;
import com.ntd.englishconversation.data.source.local.sharedprf.SharedPrefsApi;
import com.ntd.englishconversation.data.source.remote.auth.AuthenicationRepository;
import com.ntd.englishconversation.data.source.remote.comment.CommentRemoteDataSource;
import com.ntd.englishconversation.data.source.remote.comment.CommentRepository;
import com.google.firebase.auth.FirebaseUser;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Listens to user actions from the UI ({@link CreateCommentFragment}), retrieves the data and
 * updates
 * the UI as required.
 */
public final class CreateCommentPresenter
        implements CreateCommentContract.Presenter{

    private final CreateCommentContract.ViewModel mViewModel;
    private MediaModel mMediaModel;
    private String mTimelineModelId;
    private SharedPrefsApi mSharedPrefsApi;
    private CommentRepository mCommentRepository;
    private CompositeDisposable mDisposable;
    private AuthenicationRepository mAuthenicationRepository;
    private Comment mComment;

    public CreateCommentPresenter(CreateCommentContract.ViewModel viewModel, String timelineModelId,
                                  SharedPrefsApi sharedPrefsApi,
                                  AuthenicationRepository authenicationRepository) {
        mViewModel = viewModel;
        mSharedPrefsApi = sharedPrefsApi;
        mTimelineModelId = timelineModelId;
        mCommentRepository = new CommentRepository(new CommentRemoteDataSource(mTimelineModelId));
        mDisposable = new CompositeDisposable();
        mAuthenicationRepository = authenicationRepository;
    }

    public CreateCommentPresenter(CreateCommentContract.ViewModel viewModel, Comment comment,
                                  AuthenicationRepository authenicationRepository) {
        mViewModel = viewModel;
        mComment = comment;
        mAuthenicationRepository = authenicationRepository;
        mCommentRepository
                = new CommentRepository(new CommentRemoteDataSource(comment.getPostId()));
        mDisposable = new CompositeDisposable();
    }

    @Override
    public void onStart() {
        mAuthenicationRepository.getCurrentUser(new DataCallback<FirebaseUser>() {
            @Override
            public void onGetDataSuccess(FirebaseUser data) {
                mViewModel.onGetCurrentUserSuccess(new UserModel(data));
            }

            @Override
            public void onGetDataFailed(String msg) {
                mViewModel.onGetCurrentUserFailed(msg);
            }
        });
    }

    @Override
    public void onStop() {
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onRecordVideoDone(String uri, int type) {
        if (mMediaModel == null) {
            mMediaModel = new MediaModel(MediaModel.MediaType.VIDEO);
        }
        mMediaModel.setUrl(uri);
        mMediaModel.setName(mTimelineModelId + "-" + System.currentTimeMillis());
        mMediaModel.setId(mMediaModel.getName());
        mViewModel.onMultimediaFileAttached(mMediaModel);
    }

    @Override
    public void onImageSelectDone(Image image) {
        if (mMediaModel == null) {
            mMediaModel = new MediaModel(MediaModel.MediaType.IMAGE);
        }
        mMediaModel.setUrl(image.path);
        mMediaModel.setName(mTimelineModelId + "-" + System.currentTimeMillis());
        mMediaModel.setId(mMediaModel.getName());
        mViewModel.onMultimediaFileAttached(mMediaModel);
    }

    @Override
    public void onDeleteItemMediaClicked() {
        mMediaModel = null;
    }

    @Override
    public void postLiteralComment(Comment comment) {
        if ((comment.getContent() == null || TextUtils.isEmpty(comment.getContent().trim()))
                && comment.getMediaModel() == null) {
            return;
        }
        mDisposable.add(mCommentRepository.createNewComment(comment)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<Comment>() {
                    @Override
                    public void onNext(Comment comment) {
                        mViewModel.onPostLiteralCommentSuccess(comment);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mViewModel.onPostLiteralCommentFailure(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                }));
    }

    @Override
    public void updateLiteralComment(Comment commentNew, Comment commentOld) {
        if ((commentNew.getContent() == null || TextUtils.isEmpty(commentNew.getContent().trim()))
                && commentNew.getMediaModel() == null) {
            return;
        }
        mCommentRepository.saveRevisionComment(commentOld).subscribeOn(Schedulers.io()).subscribe();
        mDisposable.add(mCommentRepository.updateComment(commentNew)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<Comment>() {
                    @Override
                    public void onNext(Comment comment) {
                        mViewModel.replaceFragment();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mViewModel.onPostLiteralCommentFailure(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                }));
    }

    @Override
    public void onDestroy() {
        mDisposable.dispose();
    }

    @Override
    public void onMultimediaMenuItemClick(int type) {
        mMediaModel = new MediaModel(type);
    }

    @Override
    public void onSelectedAudioSuccess(String filePath, String fileName){
        mMediaModel.setUrl(filePath);
        mMediaModel.setName(fileName);
        mViewModel.onMultimediaFileAttached(mMediaModel);
    }
}

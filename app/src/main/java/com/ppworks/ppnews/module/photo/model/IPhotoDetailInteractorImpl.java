package com.ppworks.ppnews.module.photo.model;

import com.ppworks.ppnews.bean.SinaPhotoDetail;
import com.ppworks.ppnews.callback.RequestCallback;
import com.ppworks.ppnews.http.HostType;
import com.ppworks.ppnews.http.manager.RetrofitManager;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;

/**
 * ClassName: IPhotoDetailInteractorImpl<p>
 * Author: Tomoya-Hoo<p>
 * Fuction: 图片详情的Model层接口实现<p>
 * CreateDate: 2016/4/22 17:47<p>
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public class IPhotoDetailInteractorImpl implements IPhotoDetailInteractor<SinaPhotoDetail> {
    @Override
    public Subscription requestPhotoDetail(final RequestCallback<SinaPhotoDetail> callback, String id) {
        return RetrofitManager.getInstance(HostType.SINA_NEWS_PHOTO).getSinaPhotoDetailObservable(id)
                              .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        callback.beforeRequest();
                    }
                }).subscribeOn(AndroidSchedulers.mainThread())
                              .subscribe(new Subscriber<SinaPhotoDetail>() {
                    @Override
                    public void onCompleted() {
                        callback.requestComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.requestError(e.getLocalizedMessage());
                    }

                    @Override
                    public void onNext(SinaPhotoDetail sinaPhotoDetail) {
                        callback.requestSuccess(sinaPhotoDetail);
                    }
                });
    }
}

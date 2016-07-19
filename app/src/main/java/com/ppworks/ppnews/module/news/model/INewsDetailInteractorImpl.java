package com.ppworks.ppnews.module.news.model;

import com.ppworks.ppnews.bean.NeteaseNewsDetail;
import com.ppworks.ppnews.callback.RequestCallback;
import com.ppworks.ppnews.http.HostType;
import com.ppworks.ppnews.http.manager.RetrofitManager;
import com.socks.library.KLog;

import java.util.Map;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Func1;

/**
 * ClassName: INewsDetailInteractorImpl<p>
 * Author: Tomoya-Hoo<p>
 * Fuction: 新闻详情的Model层接口实现<p>
 * CreateDate: 2016/4/19 21:02<p>
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public class INewsDetailInteractorImpl implements INewsDetailInteractor<NeteaseNewsDetail> {

    @Override
    public Subscription requestNewsDetail(final RequestCallback<NeteaseNewsDetail> callback, final String id) {
        return RetrofitManager.getInstance(HostType.NETEASE_NEWS_VIDEO).getNewsDetailObservable(id)
                              .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        callback.beforeRequest();
                    }
                }).subscribeOn(AndroidSchedulers.mainThread())
                              .map(new Func1<Map<String, NeteaseNewsDetail>, NeteaseNewsDetail>() {
                    @Override
                    public NeteaseNewsDetail call(Map<String, NeteaseNewsDetail> map) {
                        return map.get(id);
                    }
                }).subscribe(new Subscriber<NeteaseNewsDetail>() {
                    @Override
                    public void onCompleted() {
                        callback.requestComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        KLog.e(e.getLocalizedMessage() + "\n" + e);
                        callback.requestError(e.getLocalizedMessage() + "\n" + e);
                    }

                    @Override
                    public void onNext(NeteaseNewsDetail NeteaseNewsDetail) {
                        callback.requestSuccess(NeteaseNewsDetail);
                    }
                });
    }

}

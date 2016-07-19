package com.ppworks.ppnews.module.video.model;

import com.ppworks.ppnews.bean.NeteaseVideoSummary;
import com.ppworks.ppnews.callback.RequestCallback;
import com.ppworks.ppnews.http.HostType;
import com.ppworks.ppnews.http.manager.RetrofitManager;
import com.socks.library.KLog;

import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.functions.Func2;

/**
 * ClassName: IVideoListInteractorImpl<p>
 * Author: Tomoya-Hoo<p>
 * Fuction: 视频列表Model层接口实现<p>
 * CreateDate: 2016/4/23 17:10<p>
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public class IVideoListInteractorImpl implements IVideoListInteractor<List<NeteaseVideoSummary>> {

    @Override
    public Subscription requestVideoList(final RequestCallback<List<NeteaseVideoSummary>> callback, final String id, int startPage) {
        return RetrofitManager.getInstance(HostType.NETEASE_NEWS_VIDEO)
                .getVideoListObservable(id, startPage).doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        callback.beforeRequest();
                    }
                }).subscribeOn(AndroidSchedulers.mainThread()).flatMap(
                        new Func1<Map<String, List<NeteaseVideoSummary>>, Observable<NeteaseVideoSummary>>() {
                            @Override
                            public Observable<NeteaseVideoSummary> call(Map<String, List<NeteaseVideoSummary>> map) {
                                // 通过id取到list
                                return Observable.from(map.get(id));
                            }
                        })
                .toSortedList(new Func2<NeteaseVideoSummary, NeteaseVideoSummary, Integer>() {
                    @Override
                    public Integer call(NeteaseVideoSummary neteastVideoSummary, NeteaseVideoSummary neteastVideoSummary2) {
                        // 时间排序
                        return neteastVideoSummary2.ptime.compareTo(neteastVideoSummary.ptime);
                    }
                }).subscribe(new Subscriber<List<NeteaseVideoSummary>>() {
                    @Override
                    public void onCompleted() {
                        callback.requestComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        KLog.e(e + "\n" + e.getLocalizedMessage());
                        callback.requestError(e + "\n" + e.getLocalizedMessage());
                    }

                    @Override
                    public void onNext(List<NeteaseVideoSummary> data) {
                        callback.requestSuccess(data);
                    }
                });
    }

}

package com.ppworks.ppnews.module.news.model;

import com.ppworks.ppnews.bean.NeteaseNewsSummary;
import com.ppworks.ppnews.callback.RequestCallback;
import com.ppworks.ppnews.http.Api;
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
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;

/**
 * ClassName: INewsListInteractorImpl<p>
 * Author: Tomoya-Hoo<p>
 * Fuction: 新闻列表Model层接口实现<p>
 * CreateDate: 2016/4/17 21:02<p>
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public class INewsListInteractorImpl implements INewsListInteractor<List<NeteaseNewsSummary>> {

    @Override
    public Subscription requestNewsList(final RequestCallback<List<NeteaseNewsSummary>> callback, String type, final String id, int startPage) {
        KLog.e("新闻列表：" + type + ";" + id);
        return RetrofitManager.getInstance(HostType.NETEASE_NEWS_VIDEO)
                              .getNewsListObservable(type, id, startPage).doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        // 订阅之前回调回去显示加载动画
                        callback.beforeRequest();
                    }
                }).subscribeOn(AndroidSchedulers.mainThread()) // 订阅之前操作在主线程
                              .doOnError(new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        KLog.e("错误时处理：" + throwable + " --- " + throwable.getLocalizedMessage());
                    }
                }).flatMap(
                        new Func1<Map<String, List<NeteaseNewsSummary>>, Observable<NeteaseNewsSummary>>() {
                            // map得到list转换成item
                            @Override
                            public Observable<NeteaseNewsSummary> call(Map<String, List<NeteaseNewsSummary>> map) {
                                if (id.equals(Api.HOUSE_ID)) {
                                    // 房产实际上针对地区的它的id与返回key不同
                                    return Observable.from(map.get("北京"));
                                }
                                return Observable.from(map.get(id));
                            }
                        })
                              .toSortedList(new Func2<NeteaseNewsSummary, NeteaseNewsSummary, Integer>() {
                    // 按时间先后排序
                    @Override
                    public Integer call(NeteaseNewsSummary NeteaseNewsSummary, NeteaseNewsSummary NeteaseNewsSummary2) {
                        return NeteaseNewsSummary2.ptime.compareTo(NeteaseNewsSummary.ptime);
                    }
                }).subscribe(new Subscriber<List<NeteaseNewsSummary>>() {
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
                    public void onNext(List<NeteaseNewsSummary> neteastNewsSummaries) {
                        callback.requestSuccess(neteastNewsSummaries);
                    }
                });
    }
}

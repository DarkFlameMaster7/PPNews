package com.ppworks.ppnews.module.news.model;

import com.ppworks.ppnews.callback.RequestCallback;
import rx.Subscription;

/**
 * ClassName: INewsDetailInteractor<p>
 * Author: Tomoya-Hoo<p>
 * Fuction: 新闻详情的Model层接口<p>
 * CreateDate: 2016/4/19 21:02<p>
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public interface INewsDetailInteractor<T> {

    Subscription requestNewsDetail(RequestCallback<T> callback, String id);

}

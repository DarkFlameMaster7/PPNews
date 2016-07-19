package com.ppworks.ppnews.module.news.model;

import com.ppworks.ppnews.callback.RequestCallback;
import rx.Subscription;

/**
 * ClassName: INewsListInteractor<p>
 * Author: Tomoya-Hoo<p>
 * Fuction: 新闻列表Model层接口<p>
 * CreateDate: 2016/4/17 21:02<p>
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public interface INewsListInteractor<T> {

    Subscription requestNewsList(RequestCallback<T> callback, String type, String id, int startPage);

}
package com.ppworks.ppnews.module.news.model;

import com.ppworks.ppnews.callback.RequestCallback;
import rx.Subscription;

/**
 * ClassName: INewsInteractor<p>
 * Author: Tomoya-Hoo<p>
 * Fuction: 新闻Model层接口<p>
 * CreateDate: 2016/4/20 15:05<p>
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public interface INewsInteractor<T> {

    Subscription operateChannelDb(RequestCallback<T> callback);

}

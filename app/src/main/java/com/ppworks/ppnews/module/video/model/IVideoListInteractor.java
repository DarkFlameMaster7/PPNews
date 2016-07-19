package com.ppworks.ppnews.module.video.model;

import com.ppworks.ppnews.callback.RequestCallback;

import rx.Subscription;

/**
 * ClassName: IVideoListInteractor<p>
 * Author: Tomoya-Hoo<p>
 * Fuction: 视频列表Model层接口<p>
 * CreateDate: 2016/4/23 17:10<p>
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public interface IVideoListInteractor<T> {

    Subscription requestVideoList(RequestCallback<T> callback, String id, int startPage);

}

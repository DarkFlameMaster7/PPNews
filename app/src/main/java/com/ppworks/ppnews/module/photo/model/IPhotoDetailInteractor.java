package com.ppworks.ppnews.module.photo.model;

import com.ppworks.ppnews.callback.RequestCallback;
import rx.Subscription;

/**
 * ClassName: IPhotoDetailInteractor<p>
 * Author: Tomoya-Hoo<p>
 * Fuction: 图片详情的Model层接口<p>
 * CreateDate: 2016/4/22 17:47<p>
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public interface IPhotoDetailInteractor<T> {

    Subscription requestPhotoDetail(RequestCallback<T> callback, String id);

}

package com.ppworks.ppnews.module.photo.presenter;

import com.ppworks.ppnews.base.BasePresenter;

/**
 * ClassName: IPhotoListPresenter<p>
 * Author: Tomoya-Hoo<p>
 * Fuction: 图片列表代理接口<p>
 * CreateDate: 2016/4/21 16:15<p>
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public interface IPhotoListPresenter extends BasePresenter {

    void refreshData();

    void loadMoreData();

}

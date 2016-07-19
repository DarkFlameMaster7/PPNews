package com.ppworks.ppnews.module.video.presenter;


import com.ppworks.ppnews.base.BasePresenter;

/**
 * ClassName: IVideoListPresenter<p>
 * Author: Tomoya-Hoo<p>
 * Fuction: 视频列表代理接口<p>
 * CreateDate: 2016/4/23 17:09<p>
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public interface IVideoListPresenter extends BasePresenter {

    void refreshData();

    void loadMoreData();

}

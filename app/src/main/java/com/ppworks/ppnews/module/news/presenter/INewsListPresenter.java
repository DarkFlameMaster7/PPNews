package com.ppworks.ppnews.module.news.presenter;

import com.ppworks.ppnews.base.BasePresenter;

/**
 * ClassName: INewsListPresenter<p>
 * Author: Tomoya-Hoo<p>
 * Fuction: 新闻列表代理接口<p>
 * CreateDate: 2016/4/18 14:39<p>
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public interface INewsListPresenter extends BasePresenter {

    void refreshData();

    void loadMoreData();

}

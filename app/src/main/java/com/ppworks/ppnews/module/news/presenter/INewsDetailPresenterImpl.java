package com.ppworks.ppnews.module.news.presenter;

import com.ppworks.ppnews.base.BasePresenterImpl;
import com.ppworks.ppnews.bean.NeteaseNewsDetail;
import com.ppworks.ppnews.module.news.model.INewsDetailInteractor;
import com.ppworks.ppnews.module.news.model.INewsDetailInteractorImpl;
import com.ppworks.ppnews.module.news.view.INewsDetailView;

/**
 * ClassName: INewsDetailPresenterImpl<p>
 * Author: Tomoya-Hoo<p>
 * Fuction: 新闻详情代理接口实现<p>
 * CreateDate: 2016/4/19 21:11<p>
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public class INewsDetailPresenterImpl extends BasePresenterImpl<INewsDetailView, NeteaseNewsDetail>
        implements INewsDetailPresenter {

    public INewsDetailPresenterImpl(INewsDetailView newsDetailView, String postId) {
        super(newsDetailView);
        INewsDetailInteractor<NeteaseNewsDetail> newsDetailInteractor = new INewsDetailInteractorImpl();
        mSubscription = newsDetailInteractor.requestNewsDetail(this, postId);
    }

    @Override
    public void requestSuccess(NeteaseNewsDetail data) {
        mView.initNewsDetail(data);
    }
}

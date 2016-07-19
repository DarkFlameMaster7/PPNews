package com.ppworks.ppnews.module.news.presenter;

import com.ppworks.ppnews.base.BasePresenterImpl;
import com.ppworks.ppnews.greendao.NewsChannelTable;
import com.ppworks.ppnews.module.news.model.INewsInteractor;
import com.ppworks.ppnews.module.news.model.INewsInteractorImpl;
import com.ppworks.ppnews.module.news.view.INewsView;
import java.util.List;

/**
 * ClassName: INewsPresenterImpl<p>
 * Author: Tomoya-Hoo<p>
 * Fuction: 新闻代理接口实现<p>
 * CreateDate: 2016/4/17 21:04<p>
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public class INewsPresenterImpl extends BasePresenterImpl<INewsView, List<NewsChannelTable>>
        implements INewsPresenter {

    private INewsInteractor<List<NewsChannelTable>> mNewsInteractor;

    public INewsPresenterImpl(INewsView newsView) {
        super(newsView);
        mNewsInteractor = new INewsInteractorImpl();
        mSubscription = mNewsInteractor.operateChannelDb(this);
        mView.initRxBusEvent();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void requestSuccess(List<NewsChannelTable> data) {
        mView.initViewPager(data);
    }

    @Override
    public void operateChannelDb() {
        mSubscription = mNewsInteractor.operateChannelDb(this);
    }
}

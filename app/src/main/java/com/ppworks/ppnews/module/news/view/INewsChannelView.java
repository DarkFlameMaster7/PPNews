package com.ppworks.ppnews.module.news.view;

import com.ppworks.ppnews.base.BaseView;
import com.ppworks.ppnews.greendao.NewsChannelTable;
import java.util.List;

/**
 * ClassName: INewsChannelView<p>
 * Author: Tomoya-Hoo<p>
 * Fuction: 新闻频道管理视图接口<p>
 * CreateDate: 2016/4/19 22:53<p>
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public interface INewsChannelView extends BaseView {

    void initTwoRecyclerView(List<NewsChannelTable> selectChannels, List<NewsChannelTable> unSelectChannels);

}

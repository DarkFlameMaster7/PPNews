package com.ppworks.ppnews.module.news.view;

import com.ppworks.ppnews.base.BaseView;
import com.ppworks.ppnews.bean.NeteaseNewsSummary;
import com.ppworks.ppnews.common.DataLoadType;

import java.util.List;

/**
 * ClassName: INewsListView<p>
 * Author: Tomoya-Hoo<p>
 * Fuction: 新闻列表视图接口<p>
 * CreateDate: 2016/4/18 14:42<p>
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public interface INewsListView extends BaseView {

    void updateNewsList(List<NeteaseNewsSummary> data,
                        @DataLoadType.DataLoadTypeChecker int type);

}

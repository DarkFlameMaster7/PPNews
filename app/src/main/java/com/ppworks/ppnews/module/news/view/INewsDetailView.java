package com.ppworks.ppnews.module.news.view;

import com.ppworks.ppnews.base.BaseView;
import com.ppworks.ppnews.bean.NeteaseNewsDetail;

/**
 * ClassName: INewsDetailView<p>
 * Author: Tomoya-Hoo<p>
 * Fuction: 新闻详情视图接口<p>
 * CreateDate: 2016/4/19 14:52<p>
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public interface INewsDetailView extends BaseView {

    void initNewsDetail(NeteaseNewsDetail data);

}

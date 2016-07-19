package com.ppworks.ppnews.module.photo.view;

import com.ppworks.ppnews.base.BaseView;
import com.ppworks.ppnews.bean.SinaPhotoDetail;

/**
 * ClassName: IPhotoDetailView<p>
 * Author: Tomoya-Hoo<p>
 * Fuction: 图片新闻详情视图接口<p>
 * CreateDate: 2016/4/21 1:35<p>
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public interface IPhotoDetailView extends BaseView {

    void initViewPager(SinaPhotoDetail photoList);

}

package com.ppworks.ppnews.module.video.view;


import com.ppworks.ppnews.base.BaseView;
import com.ppworks.ppnews.bean.NeteaseVideoSummary;
import com.ppworks.ppnews.common.DataLoadType;

import java.util.List;

/**
 * ClassName: IVideoListView<p>
 * Author: Tomoya-Hoo<p>
 * Fuction: 视频列表视图接口<p>
 * CreateDate: 2016/4/23 17:05<p>
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public interface IVideoListView extends BaseView {

    void updateVideoList(List<NeteaseVideoSummary> data, @DataLoadType.DataLoadTypeChecker int type);

}

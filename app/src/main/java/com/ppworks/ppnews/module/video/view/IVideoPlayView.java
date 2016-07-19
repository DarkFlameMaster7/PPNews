package com.ppworks.ppnews.module.video.view;

import com.ppworks.ppnews.base.BaseView;

/**
 * ClassName: IVideoPlayView<p>
 * Author: Tomoya-Hoo<p>
 * Fuction: 视频播放视图接口<p>
 * CreateDate: 2016/4/23 21:31<p>
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public interface IVideoPlayView extends BaseView {

    void playVideo(String path);

    void registerScreenBroadCastReceiver();

}

package com.ppworks.ppnews.module.video.presenter;


import com.ppworks.ppnews.base.BasePresenterImpl;
import com.ppworks.ppnews.module.video.view.IVideoPlayView;

/**
 * ClassName: IVideoPlayPresenterImpl<p>
 * Author: Tomoya-Hoo<p>
 * Fuction: 视频播放代理接口实现<p>
 * CreateDate: 2016/4/23 21:32<p>
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public class IVideoPlayPresenterImpl extends BasePresenterImpl<IVideoPlayView, Void>
        implements IVideoPlayPresenter {

    public IVideoPlayPresenterImpl(IVideoPlayView view, String path) {
        super(view);
        mView.registerScreenBroadCastReceiver();
        mView.playVideo(path);
        mView.showProgress();
    }
}

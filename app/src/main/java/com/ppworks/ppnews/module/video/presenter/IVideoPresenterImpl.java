package com.ppworks.ppnews.module.video.presenter;

import com.ppworks.ppnews.base.BasePresenterImpl;
import com.ppworks.ppnews.module.video.view.IVideoView;

/**
 * ClassName: IVideoPresenterImpl<p>
 * Author: Tomoya-Hoo<p>
 * Fuction: 视频代理接口实现<p>
 * CreateDate: 2016/4/23 16:42<p>
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public class IVideoPresenterImpl extends BasePresenterImpl<IVideoView, Void>
        implements IVideoPresenter {

    public IVideoPresenterImpl(IVideoView view) {
        super(view);
        mView.initViewPager();
    }


}

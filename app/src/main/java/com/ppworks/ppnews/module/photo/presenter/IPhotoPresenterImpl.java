package com.ppworks.ppnews.module.photo.presenter;

import com.ppworks.ppnews.base.BasePresenterImpl;
import com.ppworks.ppnews.module.photo.view.IPhotoView;

/**
 * ClassName: IPhotoPresenterImpl<p>
 * Author: Tomoya-Hoo<p>
 * Fuction: 图片代理接口实现<p>
 * CreateDate: 2016/4/21 3:46<p>
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public class IPhotoPresenterImpl extends BasePresenterImpl<IPhotoView, Void>
        implements IPhotoPresenter{

    public IPhotoPresenterImpl(IPhotoView view) {
        super(view);
        view.initViewPager();
    }

}

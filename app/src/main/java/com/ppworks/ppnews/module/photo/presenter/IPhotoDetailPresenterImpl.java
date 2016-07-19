package com.ppworks.ppnews.module.photo.presenter;

import com.ppworks.ppnews.base.BasePresenterImpl;
import com.ppworks.ppnews.bean.SinaPhotoDetail;
import com.ppworks.ppnews.module.photo.model.IPhotoDetailInteractor;
import com.ppworks.ppnews.module.photo.model.IPhotoDetailInteractorImpl;
import com.ppworks.ppnews.module.photo.view.IPhotoDetailView;

/**
 * ClassName: IPhotoDetailPresenterImpl<p>
 * Author: Tomoya-Hoo<p>
 * Fuction: 图片详情代理接口实现<p>
 * CreateDate: 2016/4/22 17:46<p>
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public class IPhotoDetailPresenterImpl extends BasePresenterImpl<IPhotoDetailView, SinaPhotoDetail>
        implements IPhotoDetailPresenter {

    private IPhotoDetailInteractor<SinaPhotoDetail> mDetailInteractor;

    public IPhotoDetailPresenterImpl(IPhotoDetailView view, String id, SinaPhotoDetail data) {
        super(view);
        mDetailInteractor = new IPhotoDetailInteractorImpl();
        if (data != null) {
            mView.initViewPager(data);
        } else {
            mSubscription = mDetailInteractor.requestPhotoDetail(this, id);
        }
    }

    @Override
    public void requestSuccess(SinaPhotoDetail data) {
        mView.initViewPager(data);
    }
}

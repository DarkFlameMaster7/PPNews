package com.ppworks.ppnews.module.settings.presenter;

import com.ppworks.ppnews.base.BasePresenterImpl;
import com.ppworks.ppnews.module.settings.view.ISettingsView;

/**
 * ClassName: <p>
 * Author: Tomoya-Hoo<p>
 * Fuction: <p>
 * CreateDate: 2016/4/23 0:17<p>
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public class ISettingsPresenterImpl extends BasePresenterImpl<ISettingsView, Void>
        implements ISettingsPresenter{

    public ISettingsPresenterImpl(ISettingsView view) {
        super(view);
        mView.initItemState();
    }
}

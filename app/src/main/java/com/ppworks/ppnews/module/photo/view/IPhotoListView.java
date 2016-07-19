package com.ppworks.ppnews.module.photo.view;

import com.ppworks.ppnews.base.BaseView;
import com.ppworks.ppnews.bean.SinaPhotoList;
import com.ppworks.ppnews.common.DataLoadType;
import java.util.List;

/**
 * ClassName: IPhotoListView<p>
 * Author: Tomoya-Hoo<p>
 * Fuction: 图片新闻列表接口<p>
 * CreateDate: 2016/4/21 1:35<p>
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public interface IPhotoListView extends BaseView {

    void updatePhotoList(List<SinaPhotoList.DataEntity.PhotoListEntity> data,
                         @DataLoadType.DataLoadTypeChecker int type);

}

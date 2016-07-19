package com.ppworks.ppnews.callback;

import android.view.View;

/**
 * ClassName: OnItemClickListener<p>
 * Author:Tomoya-Hoo<p>
 * Fuction: 点击长按的接口<p>
 * CreateDate:2016/4/14 1:48<p>
 * UpdateUser:<p>
 * UpdateDate:<p>
 */
public interface OnItemClickListener {
    void onItemClick(View view, int position);
    void onItemLongClick(View view, int position);
}

package com.ppworks.ppnews.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.ppworks.ppnews.R;

/**
 * Created by Tomoya-Hoo on 2016/6/11.
 */

public class SearchPopupWindow extends PopupWindow{
    private View mMenuView;
    private EditText search_edittext;
    private final Context mContext;

    public SearchPopupWindow(Context context, View.OnClickListener itemsOnClick) {
        super(context);
        this.mContext = context;
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mMenuView = inflater.inflate(R.layout.search_popup_window, null);
        InputMethodManager imm = (InputMethodManager) context
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);//弹出PopupWindow 显示软键盘
        search_edittext = (EditText) mMenuView.findViewById(R.id.search_edittext);
        search_edittext.setOnKeyListener(new View.OnKeyListener() {//监听键盘事件

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // TODO Auto-generated method stub
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    Toast.makeText(mContext, "很抱歉，没有您要搜索的内容m(_ _)m", Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }

        });
        this.setContentView(mMenuView);
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setFocusable(true);

        // this.setAnimationStyle(R.style.AnimBottom);
        ColorDrawable dw = new ColorDrawable(0xb0000000);//设置为半透明效果
        this.setBackgroundDrawable(dw);

        mMenuView.setOnTouchListener(new View.OnTouchListener() {// 搜索框下面区域
            // PopupWindow消失
            public boolean
            onTouch(View v, MotionEvent event) {
                int height =
                        mMenuView.findViewById(R.id.tel_popup_window_main).getBottom();
                int y
                        = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_UP)
                {
                    if (y > height) {
                        dismiss();
                    }
                }
                return true;
            }
        });

    }

}

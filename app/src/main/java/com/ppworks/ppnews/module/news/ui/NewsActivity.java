package com.ppworks.ppnews.module.news.ui;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.ppworks.ppnews.R;
import com.ppworks.ppnews.annotation.ActivityFragmentInject;
import com.ppworks.ppnews.app.AppManager;
import com.ppworks.ppnews.base.BaseActivity;
import com.ppworks.ppnews.base.BaseFragment;
import com.ppworks.ppnews.base.BaseFragmentAdapter;
import com.ppworks.ppnews.greendao.NewsChannelTable;
import com.ppworks.ppnews.module.news.presenter.INewsPresenter;
import com.ppworks.ppnews.module.news.presenter.INewsPresenterImpl;
import com.ppworks.ppnews.module.news.view.INewsView;
import com.ppworks.ppnews.utils.RxBus;
import com.ppworks.ppnews.utils.ViewUtil;
import com.ppworks.ppnews.widget.SearchPopupWindow;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Action1;

/**
 * ClassName: NewsActivity<p>
 * Author: Tomoya-Hoo<p>
 * Fuction: 新闻界面<p>
 * CreateDate: 2016/4/20 2:12<p>
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
@ActivityFragmentInject(contentViewId = R.layout.activity_news,
        menuId = R.menu.menu_news,
        hasNavigationView = true,
        toolbarTitle = R.string.news,
        toolbarIndicator = R.drawable.ic_list_white,
        menuDefaultCheckedItem = R.id.action_news)
public class NewsActivity extends BaseActivity<INewsPresenter> implements
        INewsView {

    private Observable<Boolean> mChannelObservable;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    Log.e("delay task", "handleMessage: " + msg.what);
                    getWindow().setBackgroundDrawable(null);
                    break;
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxBus.get().unregister("channelChange", mChannelObservable);
    }

    @Override
    protected void initView() {

        // 避免冷启动，null
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mHandler.sendEmptyMessage(1);
            }
        }, 3000);
        //        getWindow().setBackgroundDrawable(null);
        ViewUtil.quitFullScreen(this);

        AppManager.getAppManager().orderNavActivity(getClass().getName(), false);

        mPresenter = new INewsPresenterImpl(this);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_channel_manage) {
            //  跳转到频道选择界面
            showActivity(this, new Intent(this, NewsChannelActivity.class));
        }
        if (item.getItemId() == R.id.action_channel_about) {
            new MaterialDialog.Builder(this).content(R.string.about_info).show();
        }
        if (item.getItemId() == R.id.search_news) {
            SearchPopupWindow popupWindow = new SearchPopupWindow(this, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(NewsActivity.this, "404", Toast.LENGTH_SHORT).show();
                }
            });
            View viewWindow = this.getWindow().getDecorView();
            popupWindow.showAtLocation(viewWindow, Gravity.TOP, 0, 0);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void initViewPager(List<NewsChannelTable> newsChannels) {

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        List<BaseFragment> fragments = new ArrayList<>();
        final List<String> title = new ArrayList<>();

        if (newsChannels != null) {
            // 有除了固定的其他频道被选中，添加
            for (NewsChannelTable news : newsChannels) {
                final NewsListFragment fragment = NewsListFragment
                        .newInstance(news.getNewsChannelId(), news.getNewsChannelType(),
                                news.getNewsChannelIndex());

                fragments.add(fragment);
                title.add(news.getNewsChannelName());
            }

            if (viewPager.getAdapter() == null) {
                // 初始化ViewPager
                BaseFragmentAdapter adapter = new BaseFragmentAdapter(getSupportFragmentManager(),
                        fragments, title);
                viewPager.setAdapter(adapter);
            } else {
                final BaseFragmentAdapter adapter = (BaseFragmentAdapter) viewPager.getAdapter();
                adapter.updateFragments(fragments, title);
            }
            viewPager.setCurrentItem(0, false);
            tabLayout.setupWithViewPager(viewPager);
            tabLayout.setScrollPosition(0, 0, true);
            // 根据Tab的长度动态设置TabLayout的模式
            ViewUtil.dynamicSetTabLayoutMode(tabLayout);

            setOnTabSelectEvent(viewPager, tabLayout);

        } else {
            toast("数据异常");
        }

    }

    @Override
    public void initRxBusEvent() {
        mChannelObservable = RxBus.get().register("channelChange", Boolean.class);
        mChannelObservable.subscribe(new Action1<Boolean>() {
            @Override
            public void call(Boolean change) {
                if (change) {
                    mPresenter.operateChannelDb();
                }
            }
        });
    }


}

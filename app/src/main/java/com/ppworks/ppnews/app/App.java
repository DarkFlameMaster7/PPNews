package com.ppworks.ppnews.app;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.ppworks.ppnews.BuildConfig;
import com.ppworks.ppnews.common.Constant;
import com.ppworks.ppnews.greendao.DaoMaster;
import com.ppworks.ppnews.greendao.DaoSession;
import com.socks.library.KLog;
import com.zhy.changeskin.SkinManager;
import de.greenrobot.dao.query.QueryBuilder;
import io.vov.vitamio.Vitamio;

/**
 * ClassName: App<p>
 * Author:Tomoya-Hoo<p>
 * Fuction: Application<p>
 * CreateDate:2016/4/16 1:25<p>
 * UpdateUser:<p>
 * UpdateDate:<p>
 */
public class App extends Application {



    private DaoSession mDaoSession;

    private static Context sApplicationContext;

    @Override
    public void onCreate() {
        super.onCreate();
        SkinManager.getInstance().init(this);
        Vitamio.initialize(this);
        // 如果检测到某个 activity 有内存泄露，LeakCanary 就是自动地显示一个通知

        setupDatabase();
        sApplicationContext = this;
        KLog.init(BuildConfig.DEBUG);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }



    private void setupDatabase() {
        // // 官方推荐将获取 DaoMaster 对象的方法放到 Application 层，这样将避免多次创建生成 Session 对象
        // 通过 DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的 SQLiteOpenHelper 对象。
        // 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
        // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, Constant.DB_NAME, null);
        SQLiteDatabase db = helper.getWritableDatabase();
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        DaoMaster daoMaster = new DaoMaster(db);
        mDaoSession = daoMaster.newSession();
        // 在 QueryBuilder 类中内置两个 Flag 用于方便输出执行的 SQL 语句与传递参数的值
        QueryBuilder.LOG_SQL = BuildConfig.DEBUG;
        QueryBuilder.LOG_VALUES = BuildConfig.DEBUG;
    }

    /**
     * 获取dao会话
     *
     * @return
     */
    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    // 获取ApplicationContext
    public static Context getContext() {
        return sApplicationContext;
    }
}

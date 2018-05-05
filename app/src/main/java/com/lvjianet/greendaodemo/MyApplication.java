package com.lvjianet.greendaodemo;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.lvjianet.greendaodemo.bean.greendao.DaoMaster;
import com.lvjianet.greendaodemo.bean.greendao.DaoSession;

public class MyApplication extends Application {

    private DaoMaster.DevOpenHelper mHelper;
    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;
    private static MyApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        this.application = this;
        setDaoBase();
    }

    public static MyApplication getApplication() {
        return application;
    }

    private void setDaoBase() {
        mHelper = new DaoMaster.DevOpenHelper(this, "notes-db", null);
        db = mHelper.getWritableDatabase();
        // 注意：该数据库连接属于DaoMaster，所以多个 Session 指的是相同的数据库连接。
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }

    public SQLiteDatabase getDb() {
        return db;
    }

    public DaoSession getmDaoSession() {
        return mDaoSession;
    }
}

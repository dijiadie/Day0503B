package com.zql.day0503b;

import android.app.Application;

import com.example.xts.greendaodemo.db.DaoMaster;
import com.example.xts.greendaodemo.db.DaoSession;

public class Myapp extends Application {

    private static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        DaoMaster.DevOpenHelper ku = new DaoMaster.DevOpenHelper(this, "ku");
        DaoMaster daoMaster = new DaoMaster(ku.getWritableDatabase());
        daoSession = daoMaster.newSession();
    }
    public  static  DaoSession daoSession(){
        return daoSession;
    }
}

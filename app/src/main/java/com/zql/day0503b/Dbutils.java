package com.zql.day0503b;

import com.example.xts.greendaodemo.db.DaoSession;
import com.example.xts.greendaodemo.db.InfoDao;
import com.zql.day0503b.bean.Info;

import java.util.List;

public class Dbutils {
    static {
        daoSession = Myapp.daoSession();
    }

    private static DaoSession daoSession;

    public static void insect(Info info) {
        if (!query(info)) {
            daoSession.insert(info);
        }
    }

    public static void delete(Info info) {
        if (query(info)) {
            daoSession.delete(info);
        }
    }

    public static void updata(Info info) {
        if (query(info)) {
            daoSession.update(info);
        }
    }

    public static List<Info> selects() {
        List<Info> info = daoSession.loadAll(Info.class);
        return info;

    }

    public static boolean query(Info foods) {
        Info unique = daoSession.queryBuilder(Info.class).where(InfoDao.Properties.Id.eq(foods.getId())).unique();
        return unique == null ? false : true;
    }
}

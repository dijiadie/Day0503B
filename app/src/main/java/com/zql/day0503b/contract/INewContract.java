package com.zql.day0503b.contract;

import com.zql.day0503b.bean.Info;

import java.util.ArrayList;

public interface INewContract {
    interface Model {
        void getData(callBack callBack);

    }

    interface View {
        void getData(ArrayList<Info> infoData);

    }

    interface Presenter {
        void getData();
    }
    interface callBack {
        void getData(ArrayList<Info> infoData);

    }
}

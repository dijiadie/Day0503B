package com.zql.day0503b.presenter;

import com.zql.day0503b.bean.Info;
import com.zql.day0503b.contract.INewContract;
import com.zql.day0503b.model.INewModel;

import java.util.ArrayList;

public class INewPresenter implements INewContract.Presenter {
    INewContract.View view;
    private final INewModel iNewModel;

    public INewPresenter(INewContract.View view) {
        this.view=view;
        iNewModel = new INewModel();

    }


    @Override
    public void getData() {
        iNewModel.getData(new INewContract.callBack() {
            @Override
            public void getData(ArrayList<Info> infoData) {
                view.getData(infoData);
            }
        });
    }
}

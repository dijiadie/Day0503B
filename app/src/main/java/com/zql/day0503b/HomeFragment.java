package com.zql.day0503b;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.zql.day0503b.bean.Info;
import com.zql.day0503b.contract.INewContract;
import com.zql.day0503b.presenter.INewPresenter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements INewContract.View, View.OnClickListener {


    private RecyclerView recycler;
    private HomeAdapters homeAdapters;
    private Button one;
    private Button two;
    private Button three;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_home, null);
        initData();
        initView(inflate);

        return inflate;
    }

    private void initData() {

        INewPresenter iNewPresenter = new INewPresenter(this);
        iNewPresenter.getData();


    }

    private void initView(View inflate) {
        recycler = (RecyclerView) inflate.findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        homeAdapters = new HomeAdapters(getActivity());
        recycler.setAdapter(homeAdapters);
        one = (Button) inflate.findViewById(R.id.one);
        one.setOnClickListener(this);
        two = (Button) inflate.findViewById(R.id.two);
        two.setOnClickListener(this);
        three = (Button) inflate.findViewById(R.id.three);
        three.setOnClickListener(this);
    }

    @Override
    public void getData(final ArrayList<Info> infoData) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                homeAdapters.setInfoData(infoData);
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.one:
                homeAdapters.setEdit(true);
                break;
            case R.id.two:
                homeAdapters.deleter();
                break;
            case R.id.three:
                homeAdapters.setEdit(false);
                break;
        }
    }
}

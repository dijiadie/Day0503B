package com.zql.day0503b.model;

import android.util.Log;

import com.google.gson.Gson;
import com.zql.day0503b.MainActivity;
import com.zql.day0503b.bean.Info;
import com.zql.day0503b.bean.InfoBean;
import com.zql.day0503b.contract.INewContract;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class INewModel implements INewContract.Model {
    @Override
    public void getData(final INewContract.callBack callBack) {
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url("https://www.wanandroid.com/project/list/1/json?cid=294")
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Log.d(TAG, "onResponse: "+string);
               InfoBean infoBean = new Gson().fromJson(string, InfoBean.class);
                List<Info> datas = infoBean.getData().getDatas();

                callBack.getData((ArrayList<Info>) datas);
            }
        });
    }

    private static final String TAG = "INewModel";
}

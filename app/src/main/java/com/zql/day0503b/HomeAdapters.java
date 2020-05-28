package com.zql.day0503b;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.zql.day0503b.bean.Info;

import java.util.ArrayList;

public class HomeAdapters extends RecyclerView.Adapter<HomeAdapters.ViewHoler> {
    Context context;
    ArrayList<Info> infoData = new ArrayList<>();
    ArrayList<Boolean> booleans=new ArrayList<>();

    //    编辑
    boolean isEdit;

    public HomeAdapters(Context context) {
        this.context = context;

    }

    public void setInfoData(ArrayList<Info> infoData) {
        this.infoData.addAll(infoData);
        for (int i = 0; i < this.infoData.size(); i++) {
            booleans.add(false);
        }

        notifyDataSetChanged();
    }
    public void setEdit(boolean edit) {
        isEdit = edit;
        notifyDataSetChanged();
    }
    public void deleter() {
        for (int i = infoData.size()-1; i >=0 ; i--) {
            if (booleans.get(i)){
                booleans.remove(i);
                infoData.remove(i);
            }
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HomeAdapters.ViewHoler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item, viewGroup, false);
        return new ViewHoler(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull final HomeAdapters.ViewHoler viewHoler, final int i) {
        final Info info = infoData.get(i);
        viewHoler.txt.setText(info.getTitle());
        if (isEdit){

            viewHoler.cb.setVisibility(View.VISIBLE);
        }else{
            viewHoler.cb.setVisibility(View.GONE);

        }

        viewHoler.cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Boolean aBoolean = booleans.get(i);
                if (aBoolean) {
                    viewHoler.cb.setChecked(false);
                    booleans.set(i, false);
                } else {
                    booleans.set(i, true);
                    viewHoler.cb.setChecked(true);

                }

            }
        });
        Boolean aBoolean = booleans.get(i);
        viewHoler.cb.setChecked(aBoolean);
    }

    @Override
    public int getItemCount() {
        return infoData.size();
    }

    public class ViewHoler extends RecyclerView.ViewHolder {
        CheckBox cb;
        TextView txt;

        public ViewHoler(@NonNull View itemView) {
            super(itemView);
            cb = itemView.findViewById(R.id.checkboxs);
            txt = itemView.findViewById(R.id.txt_title);
        }
    }

    OnClickListener onClickListener;
    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
    public interface OnClickListener {
        void OnClickItem(Info info);
    }
}

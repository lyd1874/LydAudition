package com.femtoapp.rootsence.lydaudition;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by mac on 2017/1/18 12:27.
 * 描述：
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemHolder> {

    private Context context;

    public ItemAdapter(Context context){
        this.context = context;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemHolder(LayoutInflater.from(context).inflate(R.layout.adapter_item,parent,false));
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        if(position==MainActivity.SELECTOR){
            holder.view.setBackgroundResource(R.color.colorItemGreen);
        }else {
            holder.view.setBackgroundResource(R.color.colorItemGray);
        }
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    class ItemHolder extends RecyclerView.ViewHolder{
        View view;
        public ItemHolder(View itemView) {
            super(itemView);
            view = itemView.findViewById(R.id.view);
        }
    }
}

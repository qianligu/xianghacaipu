package com.jaxsen.xianghacaipu.ui.cook.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jaxsen.xianghacaipu.R;
import com.jaxsen.xianghacaipu.R2;
import com.jaxsen.xianghacaipu.ui.cook.activity.SearchDetailActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/4/10.
 */

public class HotSearchAdapter extends RecyclerView.Adapter<HotSearchAdapter.ViewHolder> implements View.OnClickListener {
    private Context mContext;
    private LayoutInflater inflater;
    private List<String> mData;
    private RecyclerView mRecyclerView;

    public HotSearchAdapter(Context mContext, List<String> mData) {
        if (mData != null) {
            this.mData = mData;
        } else {
            this.mData = new ArrayList<>();
        }
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }

    public void updateUser(List<String> mData) {
        if (mData != null) {
            this.mData.clear();
            this.mData.addAll(mData);
            notifyDataSetChanged();
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_hotsearch, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(mData.get(position));
        holder.itemView.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }

    @Override
    public void onClick(View v) {
        int position = mRecyclerView.getChildAdapterPosition(v);
        String msg = mData.get(position);
        Bundle bundle = new Bundle();
        bundle.putString("searchMsg",msg);
        Intent intent = new Intent(mContext, SearchDetailActivity.class);
        intent.putExtras(bundle);
        mContext.startActivity(intent);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mRecyclerView = recyclerView;
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        mRecyclerView = null;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R2.id.item_hotSearch_name)
        TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

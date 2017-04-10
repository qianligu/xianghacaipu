package com.jaxsen.xianghacaipu.ui.cook.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jaxsen.xianghacaipu.R;
import com.jaxsen.xianghacaipu.R2;
import com.jaxsen.xianghacaipu.ui.cook.bean.BannerList;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/4/10.
 */

public class NousAdapter extends RecyclerView.Adapter<NousAdapter.ViewHolder> {
    private Context mContext;
    private LayoutInflater inflater;
    private List<BannerList.DataBean.NousData> mData;

    public NousAdapter(Context mContext, List<BannerList.DataBean.NousData> mData) {
        if (mData != null) {
            this.mData = mData;
        }else {
            this.mData = new ArrayList<>();
        }
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }

    public void updateNous(List<BannerList.DataBean.NousData> mData){
        if (mData != null) {
            this.mData.clear();
            this.mData.addAll(mData);
            notifyDataSetChanged();
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_nous,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(mContext).load(mData.get(position).getImg()).into(holder.image);
        holder.title.setText(mData.get(position).getTitle());
        holder.name.setText(mData.get(position).getClassifyname());
        holder.allClick.setText(mData.get(position).getAllClick()+"浏览");
        holder.comment.setText(mData.get(position).getCommentCount()+"评论");
    }

    @Override
    public int getItemCount() {
        return mData!=null?mData.size():0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R2.id.item_nous_image)
        ImageView image;
        @BindView(R2.id.item_nous_title)
        TextView title;
        @BindView(R2.id.item_nous_allClick)
        TextView allClick;
        @BindView(R2.id.item_nous_name)
        TextView name;
        @BindView(R2.id.item_nous_comment)
        TextView comment;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}

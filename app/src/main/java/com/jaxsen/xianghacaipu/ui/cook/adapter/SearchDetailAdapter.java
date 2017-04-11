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
import com.jaxsen.xianghacaipu.ui.cook.bean.SearchDetailList;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/4/10.
 */

public class SearchDetailAdapter extends RecyclerView.Adapter<SearchDetailAdapter.ViewHolder> {
    private Context mContext;
    private LayoutInflater inflater;
    private List<SearchDetailList.DataBean.DishsBean> mData;

    public SearchDetailAdapter(Context mContext, List<SearchDetailList.DataBean.DishsBean> mData) {
        if (mData != null) {
            this.mData = mData;
        } else {
            this.mData = new ArrayList<>();
        }
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }

    public void updateSearchDetail(List<SearchDetailList.DataBean.DishsBean> mData) {
        if (mData != null) {
            this.mData.clear();
            this.mData.addAll(mData);
            notifyDataSetChanged();
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_search_detail, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(mContext).load(mData.get(position).getImg()).into(holder.image);
        String hasVideo = mData.get(position).getHasVideo();
        if (hasVideo.equals("2")) {
            holder.hasVideo.setVisibility(View.VISIBLE);
        } else if (hasVideo.equals("1")) {
            holder.hasVideo.setVisibility(View.GONE);
        }
        int isFine = mData.get(position).getIsFine();
        if (isFine == 2) {
            holder.jing.setVisibility(View.VISIBLE);
        } else if (isFine == 1) {
            holder.jing.setVisibility(View.GONE);
        }
        holder.name.setText(mData.get(position).getName());
        holder.burdens.setText(mData.get(position).getBurdens());
        holder.nickName.setText(mData.get(position).getCustomers().getNickName());
        holder.allClick.setText(mData.get(position).getAllClick()+"浏览");
        holder.favorites.setText(mData.get(position).getFavorites()+"收藏");

    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R2.id.item_search_detail_image)
        ImageView image;
        @BindView(R2.id.item_search_detail_hasVideo)
        ImageView hasVideo;
        @BindView(R2.id.item_search_detail_jing)
        TextView jing;
        @BindView(R2.id.item_search_detail_burdens)
        TextView burdens;
        @BindView(R2.id.item_search_detail_nickName)
        TextView nickName;
        @BindView(R2.id.item_search_detail_allClick)
        TextView allClick;
        @BindView(R2.id.item_search_detail_favorites)
        TextView favorites;
        @BindView(R2.id.item_search_detail_name)
        TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

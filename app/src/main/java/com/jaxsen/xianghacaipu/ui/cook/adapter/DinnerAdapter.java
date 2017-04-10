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
import com.jaxsen.xianghacaipu.ui.cook.bean.DinnerList;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by Administrator on 2017/4/10.
 */

public class DinnerAdapter extends RecyclerView.Adapter<DinnerAdapter.ViewHolder> {
    private Context mContext;
    private LayoutInflater inflater;
    private List<DinnerList.DinnerData> mData;

    public DinnerAdapter(Context mContext, List<DinnerList.DinnerData> mData) {
        if (mData != null) {
            this.mData = mData;
        } else {
            this.mData = new ArrayList<>();
        }
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }

    public void updateDinner(List<DinnerList.DinnerData> mData) {
        if (mData != null) {
            this.mData.clear();
            this.mData.addAll(mData);
            notifyDataSetChanged();
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_dinner, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(mContext).load(mData.get(position).getImg()).into(holder.image_bg);
        Glide.with(mContext).load(mData.get(position).getCustomer().getImg()).bitmapTransform(new CropCircleTransformation(mContext)).into(holder.image_head);
        String isGourmet = mData.get(position).getCustomer().getIsGourmet();
        if (isGourmet.equals("2")) {
            holder.image_vip.setVisibility(View.VISIBLE);
        } else if (isGourmet.equals("1")) {
            holder.image_vip.setVisibility(View.GONE);
        }
        String isExclusive = mData.get(position).getIsExclusive();
        if (isExclusive.equals("2")) {
            holder.self.setVisibility(View.VISIBLE);
        } else {
            holder.self.setVisibility(View.GONE);
        }
        holder.name.setText(mData.get(position).getName());
        holder.allClick.setText(mData.get(position).getAllClick());
        holder.favorites.setText(mData.get(position).getFavorites());
        holder.nickName.setText(mData.get(position).getCustomer().getNickName());
    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R2.id.item_dinner_big_image)
        ImageView image_bg;
        @BindView(R2.id.item_dinner_small_image)
        ImageView image_head;
        @BindView(R2.id.item_dinner_vip)
        ImageView image_vip;
        @BindView(R2.id.item_dinner_name)
        TextView name;
        @BindView(R2.id.item_dinner_allClick)
        TextView allClick;
        @BindView(R2.id.item_dinner_favorites)
        TextView favorites;
        @BindView(R2.id.item_dinner_nickName)
        TextView nickName;
        @BindView(R2.id.item_dinner_self)
        TextView self;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

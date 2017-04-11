package com.jaxsen.xianghacaipu.ui.cook.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jaxsen.xianghacaipu.R;
import com.jaxsen.xianghacaipu.R2;
import com.jaxsen.xianghacaipu.ui.cook.bean.JXMenuList;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/4/10.
 */

public class JXMenuAdapter extends RecyclerView.Adapter<JXMenuAdapter.ViewHolder> {
    private Context mContext;
    private LayoutInflater inflater;
    private List<JXMenuList.DataBean.DishsBean> mData;

    public JXMenuAdapter(Context mContext, List<JXMenuList.DataBean.DishsBean> mData) {
        if (mData != null) {
            this.mData = mData;
        } else {
            this.mData = new ArrayList<>();
        }
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }

    public void updateDinner(List<JXMenuList.DataBean.DishsBean> mData) {
        if (mData != null) {
            this.mData.clear();
            this.mData.addAll(mData);
            notifyDataSetChanged();
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_jxmenu, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(mContext).load(mData.get(position).getImg()).into(holder.image);
          int  isFine = mData.get(position).getIsFine();
        if (isFine==2) {
            holder.jh.setVisibility(View.VISIBLE);
        } else if (isFine==1) {
            holder.jh.setVisibility(View.GONE);
        }
        holder.name.setText(mData.get(position).getName());
        holder.allClick.setText(mData.get(position).getAllClick()+"浏览");
        holder.favorites.setText(mData.get(position).getFavorites()+"收藏");
        holder.nickName.setText(mData.get(position).getCustomer().getNickName());
    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R2.id.item_jxmenu_dishs_image)
        ImageView image;
        @BindView(R2.id.item_jxmenu_dishs_jh)
        TextView jh;
        @BindView(R2.id.item_jxmenu_dishs_allClick)
        TextView allClick;
        @BindView(R2.id.item_jxmenu_dishs_favorites)
        TextView favorites;
        @BindView(R2.id.item_jxmenu_dishs_nickName)
        TextView nickName;
        @BindView(R2.id.item_jxmenu_dishs_name)
        TextView name;
        @BindView(R2.id.item_jxmenu_dishs_like)
        CheckBox like;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

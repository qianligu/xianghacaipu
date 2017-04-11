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
import com.jaxsen.xianghacaipu.ui.cook.bean.EpicureList;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by Administrator on 2017/4/10.
 */

public class RightAdapter extends RecyclerView.Adapter<RightAdapter.ViewHolder> {
    private Context mContext;
    private LayoutInflater inflater;
    private List<EpicureList.DataBean> mData;

    public RightAdapter(Context mContext, List<EpicureList.DataBean> mData) {
        if (mData != null) {
            this.mData = mData;
        } else {
            this.mData = new ArrayList<>();
        }
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }

    public void updateNous(List<EpicureList.DataBean> mData) {
        if (mData != null) {
            this.mData.clear();
            this.mData.addAll(mData);
            notifyDataSetChanged();
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_popular_right, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(mContext).load(mData.get(position).getImg()).bitmapTransform(new CropCircleTransformation(mContext)).into(holder.image);
        holder.nickName.setText(mData.get(position).getNickName());
        holder.subjectNum.setText("美食贴"+mData.get(position).getAllSubjectNum());
        holder.likeNum.setText("被赞"+mData.get(position).getAllLikeNum());
        String isGourmet = mData.get(position).getIsGourmet();
        if (isGourmet.equals("2")) {
            holder.vip.setVisibility(View.VISIBLE);
        }else if (isGourmet.equals("1")){
            holder.vip.setVisibility(View.GONE);
        }
        boolean checked = holder.gz.isChecked();
        if (checked) {
            holder.gz.setText("已关注");
        }else {
            holder.gz.setText("关注");
        }
    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R2.id.item_popular_right_image)
        ImageView image;
        @BindView(R2.id.item_popular_right_vip)
        ImageView vip;
        @BindView(R2.id.item_popular_right_level)
        ImageView level;

        @BindView(R2.id.item_popular_right_nickName)
        TextView nickName;
        @BindView(R2.id.item_popular_right_subjectNum)
        TextView subjectNum;
        @BindView(R2.id.item_popular_right_likeNum)
        TextView likeNum;
        @BindView(R2.id.item_popular_right_gz)
        CheckBox gz;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

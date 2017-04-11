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
import jp.wasabeef.glide.transformations.CropCircleTransformation;

import static android.view.View.GONE;

/**
 * Created by Administrator on 2017/4/10.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private Context mContext;
    private LayoutInflater inflater;
    private List<BannerList.DataBean.userData> mData;

    public UserAdapter(Context mContext, List<BannerList.DataBean.userData> mData) {
        if (mData != null) {
            this.mData = mData;
        }else {
            this.mData = new ArrayList<>();
        }
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }

    public void updateUser(List<BannerList.DataBean.userData> mData){
        if (mData != null) {
            this.mData.clear();
            this.mData.addAll(mData);
            notifyDataSetChanged();
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_user,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(mContext).load(mData.get(position).getImg()).bitmapTransform(new CropCircleTransformation(mContext)).into(holder.image);
        String isGourmet = mData.get(position).getIsGourmet();
        if (isGourmet.equals("2")){
            holder.isVip.setVisibility(View.VISIBLE);
        }else if (isGourmet.equals("1")){
            holder.isVip.setVisibility(GONE);
        }
        holder.nickName.setText(mData.get(position).getNickName());
    }

    @Override
    public int getItemCount() {
        return mData!=null?mData.size():0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R2.id.item_user_image)
        ImageView image;
        @BindView(R2.id.item_user_isVip)
        ImageView isVip;
        @BindView(R2.id.item_user_nickName)
        TextView nickName;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}

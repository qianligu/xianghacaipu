package com.jaxsen.xianghacaipu.ui.food.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaxsen.xianghacaipu.R;
import com.jaxsen.xianghacaipu.R2;
import com.jaxsen.xianghacaipu.ui.food.bean.ParseNew;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ALong on 2017/4/10.
 */

public class NewRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    List<ParseNew.DataBeanX.DataBean> data;
    LayoutInflater inflater;
    Context context;

    public NewRecyclerAdapter(Context context, List<ParseNew.DataBeanX.DataBean> data) {
        if (data != null) {
            this.data = data;
        } else {
            this.data = new ArrayList<>();
        }
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    public void upDataRes(List<ParseNew.DataBeanX.DataBean> data) {

        if (data != null) {
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }

    @Override
    public int getItemViewType(int position) {
        return data.get(position+1).getImgs().size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;
        switch (viewType) {
            case 1:
                itemView = inflater.inflate(R.layout.food2_recycler_item3, parent, false);
                return new ViewHolder1(itemView);
            case 2:
                itemView = inflater.inflate(R.layout.food2_recycler_item2, parent, false);
                return new ViewHolder2(itemView);
            case 3:
                itemView = inflater.inflate(R.layout.food2_recycler_item1, parent, false);
                return new ViewHolder3(itemView);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case 1:
                if (holder instanceof ViewHolder1) {
                    ViewHolder1 holder1 = (ViewHolder1) holder;
                    Picasso.with(context).load(data.get(position + 1).getCustomer().getImg()).into(holder1.mIcon);
                    holder1.mName.setText(data.get(position + 1).getCustomer().getNickName());
                    holder1.mTime.setText(data.get(position + 1).getTimeShow());
                    if (data.get(position + 1).getContent() == null) {
                        if (holder1.mText.getVisibility() == View.VISIBLE) {
                            holder1.mText.setVisibility(View.GONE);
                        }
                    } else {

                        holder1.mText.setText(data.get(position + 1).getContent());
                    }
                    Picasso.with(context).load(data.get(position + 1).getImgs().get(0)).into(holder1.mImg1);
                    holder1.mLook.setText(data.get(position + 1).getClick());
                    holder1.mComment.setText(data.get(position + 1).getCommentNum());
                    holder1.mZan.setText(data.get(position + 1).getLikeNum());
                }

                break;
            case 2:
                if (holder instanceof ViewHolder2) {
                    ViewHolder2 holder2 = (ViewHolder2) holder;
                    Picasso.with(context).load(data.get(position + 1).getCustomer().getImg()).into(holder2.mIcon);
                    holder2.mName.setText(data.get(position + 1).getCustomer().getNickName());
                    holder2.mTime.setText(data.get(position + 1).getTimeShow());
                    if (data.get(position + 1).getContent() == null) {
                        if (holder2.mText.getVisibility() == View.VISIBLE) {
                            holder2.mText.setVisibility(View.GONE);
                        }
                    } else {

                        holder2.mText.setText(data.get(position + 1).getContent());
                    }
                    Picasso.with(context).load(data.get(position + 1).getImgs().get(0)).into(holder2.mImg1);
                    Picasso.with(context).load(data.get(position + 1).getImgs().get(1)).into(holder2.mImg2);
                    holder2.mLook.setText(data.get(position + 1).getClick());
                    holder2.mComment.setText(data.get(position + 1).getCommentNum());
                    holder2.mZan.setText(data.get(position + 1).getLikeNum());
                }

                break;
            case 3:
                if (holder instanceof ViewHolder3) {
                    ViewHolder3 holder3 = (ViewHolder3) holder;
                    Picasso.with(context).load(data.get(position + 1).getCustomer().getImg()).into(holder3.mIcon);
                    holder3.mName.setText(data.get(position + 1).getCustomer().getNickName());
                    holder3.mTime.setText(data.get(position + 1).getTimeShow());
                    if (data.get(position + 1).getContent() == null) {
                        if (holder3.mText.getVisibility() == View.VISIBLE) {
                            holder3.mText.setVisibility(View.GONE);
                        }
                    } else {
                        holder3.mText.setText(data.get(position + 1).getContent());
                    }

                    Picasso.with(context).load(data.get(position + 1).getImgs().get(0)).into(holder3.mImg1);
                    Picasso.with(context).load(data.get(position + 1).getImgs().get(1)).into(holder3.mImg2);
                    Picasso.with(context).load(data.get(position + 1).getImgs().get(2)).into(holder3.mImg3);
                    holder3.mLook.setText(data.get(position + 1).getClick());
                    holder3.mComment.setText(data.get(position + 1).getCommentNum());
                    holder3.mZan.setText(data.get(position + 1).getLikeNum());
                }

                break;
        }
    }


    public static class ViewHolder1 extends RecyclerView.ViewHolder {

        @BindView(R2.id.info3_img)
        ImageView mIcon;
        @BindView(R2.id.info3_name)
        TextView mName;
        @BindView(R2.id.info3_times)
        TextView mTime;
        @BindView(R2.id.info3_text)
        TextView mText;
        @BindView(R2.id.info3_image1)
        ImageView mImg1;
        @BindView(R2.id.info3_looking)
        TextView mLook;
        @BindView(R2.id.info3_comment)
        TextView mComment;
        @BindView(R2.id.info3_dianzan)
        TextView mZan;

        public ViewHolder1(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public static class ViewHolder2 extends RecyclerView.ViewHolder {

        @BindView(R2.id.info2_img)
        ImageView mIcon;
        @BindView(R2.id.info2_name)
        TextView mName;
        @BindView(R2.id.info2_times)
        TextView mTime;
        @BindView(R2.id.info2_text)
        TextView mText;
        @BindView(R2.id.info2_image1)
        ImageView mImg1;
        @BindView(R2.id.info2_image2)
        ImageView mImg2;
        @BindView(R2.id.info2_looking)
        TextView mLook;
        @BindView(R2.id.info2_comment)
        TextView mComment;
        @BindView(R2.id.info2_dianzan)
        TextView mZan;

        public ViewHolder2(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public static class ViewHolder3 extends RecyclerView.ViewHolder {

        @BindView(R2.id.info_img)
        ImageView mIcon;
        @BindView(R2.id.info_name)
        TextView mName;
        @BindView(R2.id.info_times)
        TextView mTime;
        @BindView(R2.id.info_text)
        TextView mText;
        @BindView(R2.id.info_image1)
        ImageView mImg1;
        @BindView(R2.id.info_image3)
        ImageView mImg3;
        @BindView(R2.id.info_image2)
        ImageView mImg2;
        @BindView(R2.id.info_looking)
        TextView mLook;
        @BindView(R2.id.info_comment)
        TextView mComment;
        @BindView(R2.id.info_dianzan)
        TextView mZan;

        public ViewHolder3(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}

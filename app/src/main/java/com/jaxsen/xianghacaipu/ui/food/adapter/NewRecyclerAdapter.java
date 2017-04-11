package com.jaxsen.xianghacaipu.ui.food.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jaxsen.xianghacaipu.R;
import com.jaxsen.xianghacaipu.R2;
import com.jaxsen.xianghacaipu.ui.food.activity.DetailActivity;
import com.jaxsen.xianghacaipu.ui.food.bean.ParseNew;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ALong on 2017/4/10.
 */

public class NewRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {


    private static final String TAG = NewRecyclerAdapter.class.getSimpleName();
    List<ParseNew.DataBeanX.DataBean> data;
    LayoutInflater inflater;
    Context context;
    private RecyclerView mRecyclerView;
    private String item1_icon;
    private String item1_img;
    private String item2_icon;
    private String item2_img1;
    private String item2_img2;
    private String item3_icon;
    private String item3_img1;
    private String item3_img2;
    private String item3_img3;

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
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mRecyclerView = recyclerView;

    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        mRecyclerView = null;
    }

    public void removeItem(int position) {

        data.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public int getItemViewType(int position) {
        if (position > 4) {
            return 5;
        }
        return data.get(position + 1).getImgs().size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;

        switch (viewType) {
            case 5:
                itemView = inflater.inflate(R.layout.food2_recycler_item, parent, false);
                return new ViewHolder0(itemView);
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
        holder.itemView.setOnClickListener(this);
        if (position <= 5) {
            switch (getItemViewType(position)) {
                case 1:
                    if (holder instanceof ViewHolder1) {
                        ViewHolder1 holder1 = (ViewHolder1) holder;
                        item1_icon = data.get(position + 1).getCustomer().getImg();
                        Log.e(TAG, "onClick: " +item1_icon);
                        Picasso.with(context).load(item1_icon).into(holder1.mIcon);
                        holder1.mName.setText(data.get(position + 1).getCustomer().getNickName());
                        holder1.mTime.setText(data.get(position + 1).getTimeShow());
                        if (data.get(position + 1).getContent() .isEmpty()) {
                            holder1.mText.setVisibility(View.GONE);
                        } else {
                            holder1.mText.setText(data.get(position + 1).getContent());
                        }
                        item1_img = data.get(position + 1).getImgs().get(0);
                        Picasso.with(context).load(item1_img).into(holder1.mImg1);
                        holder1.mLook.setText(data.get(position + 1).getClick());
                        holder1.mComment.setText(data.get(position + 1).getCommentNum());
                        holder1.mZan.setText(data.get(position + 1).getLikeNum());
                    }
                    break;
                case 2:
                    if (holder instanceof ViewHolder2) {
                        ViewHolder2 holder2 = (ViewHolder2) holder;
                        item2_icon = data.get(position + 1).getCustomer().getImg();
                        Picasso.with(context).load(item2_icon).into(holder2.mIcon);
                        holder2.mName.setText(data.get(position + 1).getCustomer().getNickName());
                        holder2.mTime.setText(data.get(position + 1).getTimeShow());
                        if (data.get(position + 1).getContent().isEmpty()) {
                            holder2.mText.setVisibility(View.GONE);
                        } else {

                            holder2.mText.setText(data.get(position + 1).getContent());
                        }
                        item2_img1 = data.get(position + 1).getImgs().get(0);
                        Picasso.with(context).load(item2_img1).into(holder2.mImg1);
                        item2_img2 = data.get(position + 1).getImgs().get(1);
                        Picasso.with(context).load(item2_img2).into(holder2.mImg2);
                        holder2.mLook.setText(data.get(position + 1).getClick());
                        holder2.mComment.setText(data.get(position + 1).getCommentNum());
                        holder2.mZan.setText(data.get(position + 1).getLikeNum());
                    }

                    break;
                case 3:
                    if (holder instanceof ViewHolder3) {
                        ViewHolder3 holder3 = (ViewHolder3) holder;
                        item3_icon = data.get(position + 1).getCustomer().getImg();
                        Picasso.with(context).load(item3_icon).into(holder3.mIcon);
                        holder3.mName.setText(data.get(position + 1).getCustomer().getNickName());
                        holder3.mTime.setText(data.get(position + 1).getTimeShow());
                        if (data.get(position + 1).getContent().isEmpty()) {
                            holder3.mText.setVisibility(View.GONE);
                        } else {
                            holder3.mText.setText(data.get(position + 1).getContent());
                        }

                        item3_img1 = data.get(position + 1).getImgs().get(0);
                        Picasso.with(context).load(item3_img1).into(holder3.mImg1);
                        item3_img2 = data.get(position + 1).getImgs().get(1);
                        Picasso.with(context).load(item3_img2).into(holder3.mImg2);
                        item3_img3 = data.get(position + 1).getImgs().get(2);
                        Picasso.with(context).load(item3_img3).into(holder3.mImg3);
                        holder3.mLook.setText(data.get(position + 1).getClick());
                        holder3.mComment.setText(data.get(position + 1).getCommentNum());
                        holder3.mZan.setText(data.get(position + 1).getLikeNum());

                    }
                    break;
            }
        }
    }

    @Override
    public void onClick(View view) {

        RecyclerView.ViewHolder holder = mRecyclerView.getChildViewHolder(view);
        Intent intent = new Intent(context, DetailActivity.class);
        Bundle bundle = new Bundle();
        if (holder instanceof ViewHolder1) {
            bundle.putString("touxiang",this.item1_icon);
            bundle.putString("img1",item1_img);
            bundle.putString("img2","");
            bundle.putString("img3","");
            bundle.putCharSequence("name", ((ViewHolder1) holder).mName.getText());
            bundle.putCharSequence("time", ((ViewHolder1) holder).mTime.getText());
            bundle.putCharSequence("text", ((ViewHolder1) holder).mText.getText());

        }
        if (holder instanceof ViewHolder2) {
            bundle.putString("touxiang",this.item2_icon);
            bundle.putString("img1",item2_img1);
            bundle.putString("img2",item2_img2);
            bundle.putString("img3","");
            bundle.putCharSequence("name", ((ViewHolder2) holder).mName.getText());
            bundle.putCharSequence("time", ((ViewHolder2) holder).mTime.getText());
            bundle.putCharSequence("text", ((ViewHolder2) holder).mText.getText());

        }
        if (holder instanceof ViewHolder3) {
            bundle.putString("touxiang",this.item3_icon);
            bundle.putString("img1",item3_img1);
            bundle.putString("img2",item3_img2);
            bundle.putString("img3",item3_img3);
            bundle.putCharSequence("name", ((ViewHolder3) holder).mName.getText());
            bundle.putCharSequence("time", ((ViewHolder3) holder).mTime.getText());
            bundle.putCharSequence("text", ((ViewHolder3) holder).mText.getText());

        }
        intent.putExtras(bundle);
        context.startActivity(intent);
    }


    public static class ViewHolder0 extends RecyclerView.ViewHolder {
        @BindView(R2.id.info_bottom)
        TextView mBottom;

        public ViewHolder0(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
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

    public static class ViewHolderGrid extends RecyclerView.ViewHolder {

        @BindView(R2.id.food2_grid)
        GridView gridView;

        public ViewHolderGrid(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

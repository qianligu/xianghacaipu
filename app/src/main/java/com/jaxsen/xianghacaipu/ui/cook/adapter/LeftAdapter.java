package com.jaxsen.xianghacaipu.ui.cook.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jaxsen.xianghacaipu.R;
import com.jaxsen.xianghacaipu.R2;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.view.View.GONE;

/**
 * Created by Administrator on 2017/4/10.
 */

public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.ViewHolder> implements View.OnClickListener {
    private Context mContext;
    private LayoutInflater inflater;
    private List<String> mData;
    private RecyclerView mRecyclerView;

    public LeftAdapter(Context mContext, List<String> mData) {
        if (mData != null) {
            this.mData = mData;
        } else {
            this.mData = new ArrayList<>();
        }
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }

    public void updateType(List<String> mData) {
        if (mData != null) {
            this.mData.clear();
            this.mData.addAll(mData);
            notifyDataSetChanged();
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_popular_left, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.type.setText(mData.get(position));
        holder.itemView.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }

    @Override
    public void onClick(View v) {
        int position = mRecyclerView.getChildAdapterPosition(v);
        LeftAdapter.ViewHolder holder = (ViewHolder) mRecyclerView.getChildViewHolder(v);
        selectedItem(holder, position);
        SendPosition event = new SendPosition(100);
        event.setPosition(position);
        EventBus.getDefault().post(event);
    }

    private void selectedItem(ViewHolder holder, int position) {
        for (int i = 0; i < mData.size(); i++) {
            if (i == position) {
                holder.type.setTextColor(Color.BLACK);
                holder.itemView.setBackgroundColor(Color.WHITE);
                holder.line.setVisibility(View.VISIBLE);

            }else {
                LeftAdapter.ViewHolder childViewHolder = (ViewHolder) mRecyclerView.getChildViewHolder(mRecyclerView.getChildAt(i));
                childViewHolder.type.setTextColor(Color.GRAY);
                childViewHolder.itemView.setBackgroundColor(Color.rgb(242,242,242));
                childViewHolder.line.setVisibility(GONE);
            }
        }
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

        @BindView(R2.id.item_popular_left_type)
        TextView type;
        @BindView(R2.id.item_popular_left_line)
        TextView line;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

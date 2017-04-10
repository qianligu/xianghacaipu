package com.jaxsen.xianghacaipu.ui.food.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jaxsen.xianghacaipu.R;
import com.jaxsen.xianghacaipu.ui.food.bean.ParseNew;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ALong on 2017/4/10.
 */

public class GrideAdapter extends BaseAdapter {

    private static final String TAG = GrideAdapter.class.getSimpleName();

    List<ParseNew.DataBeanX.DataBean.ListBean> data;
    LayoutInflater inflater;

    public GrideAdapter(Context context, List<ParseNew.DataBeanX.DataBean.ListBean> data) {
        this.inflater = LayoutInflater.from(context);
        if (data == null) {
            this.data = new ArrayList<>();
        } else {
            this.data = data;
        }
    }
    public void addRes(List<ParseNew.DataBeanX.DataBean.ListBean> data){
        if (data != null) {
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    @Override
    public int getCount() {
        return data != null ? data.size() : 0;
    }

    @Override
    public ParseNew.DataBeanX.DataBean.ListBean getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view=inflater.inflate(R.layout.food2_grid_item,viewGroup,false);
            holder=new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder= (ViewHolder) view.getTag();
        }

        holder.mTextView.setText(getItem(i).getName());

        return view;
    }

    public static class ViewHolder {
        TextView mTextView;

        public ViewHolder(View itemView) {
            mTextView = (TextView) itemView.findViewById(R.id.food2_grid_item_text);
        }
    }

}

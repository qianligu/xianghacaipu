package com.jaxsen.xianghacaipu.ui.food.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaxsen.xianghacaipu.R;
import com.jaxsen.xianghacaipu.R2;
import com.rock.mvplibrary.base.BaseActivity;
import com.squareup.picasso.Picasso;

import butterknife.BindView;

import static android.view.View.VISIBLE;

public class DetailActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = DetailActivity.class.getSimpleName();
    @BindView(R2.id.detail_title_back)
    ImageView mBack;
    @BindView(R2.id.detail_info_img)
    ImageView mIcon;
    @BindView(R2.id.detail_info_name)
    TextView mName;
    @BindView(R2.id.detail_info_times)
    TextView mTime;
    @BindView(R2.id.detail_info_text)
    TextView mContent;
    @BindView(R2.id.detail_info_img1)
    ImageView m1;
    @BindView(R2.id.detail_info_img2)
    ImageView m2;
    @BindView(R2.id.detail_info_img3)
    ImageView m3;


    @Override
    public int getLayoutId() {
        return R.layout.activity_detail;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String touxiang = bundle.getString("touxiang");
        Picasso.with(this).load(touxiang).into(mIcon);
        String img1 = bundle.getString("img1");
        Picasso.with(this).load(img1).into(m1);
        String img2 = bundle.getString("img2");
        if (!img2.isEmpty()) {
            m2.setVisibility(VISIBLE);
            Picasso.with(this).load(img2).into(m2);
        }
        String img3 = bundle.getString("img3");
        if (!img3.isEmpty()) {
            m3.setVisibility(VISIBLE);
            Picasso.with(this).load(img3).into(m3);
        }



        mName.setText(bundle.getCharSequence("name"));
        mTime.setText(bundle.getCharSequence("time"));
        CharSequence text = bundle.getCharSequence("text");
        if (text.toString().isEmpty()) {
            if(mContent.getVisibility()==VISIBLE){
                mContent.setVisibility(View.GONE);
            }
        }else {
            mContent.setText(text);
        }
        mBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.detail_title_back:

                this.finish();
                break;
        }
    }
}

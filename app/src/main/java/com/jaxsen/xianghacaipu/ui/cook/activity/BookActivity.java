package com.jaxsen.xianghacaipu.ui.cook.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.jaxsen.xianghacaipu.R;
import com.jaxsen.xianghacaipu.R2;
import com.rock.mvplibrary.base.BaseActivity;

import butterknife.BindView;

public class BookActivity extends BaseActivity implements View.OnClickListener {


    @BindView(R2.id.fenlei_back)
    ImageView mBack;


    @Override
    public int getLayoutId() {
        return R.layout.activity_book;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {

        mBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fenlei_back:
                this.finish();
                break;
        }
    }
}

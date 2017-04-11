package com.jaxsen.xianghacaipu.ui.cook.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jaxsen.xianghacaipu.R;
import com.jaxsen.xianghacaipu.R2;
import com.jaxsen.xianghacaipu.contract.HttpParams;
import com.jaxsen.xianghacaipu.ui.cook.adapter.LeftAdapter;
import com.jaxsen.xianghacaipu.ui.cook.adapter.RightAdapter;
import com.jaxsen.xianghacaipu.ui.cook.adapter.SendPosition;
import com.jaxsen.xianghacaipu.ui.cook.bean.EpicureList;
import com.jaxsen.xianghacaipu.ui.cook.contract.EpicureContract;
import com.jaxsen.xianghacaipu.ui.cook.model.EpicureListModel;
import com.jaxsen.xianghacaipu.ui.cook.presenter.EpicureListPresenter;
import com.rock.mvplibrary.base.BaseActivity;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class PopularActivity extends BaseActivity<EpicureListPresenter, EpicureListModel> implements EpicureContract.View {

    private LeftAdapter leftAdapter;
    @BindView(R2.id.recycler_popular_left)
    RecyclerView left;
    private List<String> mData;

    private RightAdapter rightAdapter;
    @BindView(R2.id.recycler_popular_right)
    RecyclerView right;

    @Override
    public int getLayoutId() {
        return R.layout.activity_popular;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
        mPresenter.getEpicureList("day", "1");
    }

    @Override
    public void initView() {
        initLeft();
        initRight();
    }

    private void initLeft() {
        leftAdapter = new LeftAdapter(this, null);
        left.setAdapter(leftAdapter);
        LinearLayoutManager leftManager = new LinearLayoutManager(this);
        leftManager.setOrientation(LinearLayoutManager.VERTICAL);
        left.setLayoutManager(leftManager);
        setLeftData();
    }

    private void initRight() {
        rightAdapter = new RightAdapter(this, null);
        right.setAdapter(rightAdapter);
        LinearLayoutManager rightManager = new LinearLayoutManager(this);
        rightManager.setOrientation(LinearLayoutManager.VERTICAL);
        right.setLayoutManager(rightManager);
    }

    private void setLeftData() {
        mData = new ArrayList<>();
        mData.add("推荐");
        mData.add("烘培");
        mData.add("家常菜");
        mData.add("面点");
        mData.add("煲汤");
        mData.add("西餐");
        mData.add("摄影");
        mData.add("官方号");
        leftAdapter.updateType(mData);
    }

    @Subscribe
    public void getPosition(SendPosition event) {
        int position = event.getPosition();
        switch (position) {
            case 0:
                mPresenter.getEpicureList("day", "1");
                break;
            case 1:
                mPresenter.getEpicureList(HttpParams.HP, "1");
                break;
            case 2:
                mPresenter.getEpicureList(HttpParams.JCC, "1");
                break;
            case 3:
                mPresenter.getEpicureList(HttpParams.MD, "1");
                break;
            case 4:
                mPresenter.getEpicureList(HttpParams.BT, "1");
                break;
            case 5:
                mPresenter.getEpicureList(HttpParams.XC, "1");
                break;
            case 6:
                mPresenter.getEpicureList(HttpParams.SY, "1");
                break;
            case 7:
                mPresenter.getEpicureList(HttpParams.GFH, "1");
                break;
        }
        rightAdapter.notifyDataSetChanged();
    }

    @Override
    public void onStartLoad() {

    }

    @Override
    public void onStopLoad() {

    }

    @Override
    public void onError(String errorInfo) {

    }

    @Override
    public void returnEpicureList(EpicureList epicureList) {
        rightAdapter.updateNous(epicureList.getData());
    }
}

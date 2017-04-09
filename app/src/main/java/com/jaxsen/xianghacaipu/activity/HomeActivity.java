package com.jaxsen.xianghacaipu.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.jaxsen.xianghacaipu.R;
import com.jaxsen.xianghacaipu.R2;
import com.jaxsen.xianghacaipu.ui.cook.fragment.CookFragment;
import com.jaxsen.xianghacaipu.ui.food.fragment.FoodFragment;
import com.jaxsen.xianghacaipu.ui.message.fragment.MessageFragment;
import com.jaxsen.xianghacaipu.ui.mine.fragment.MineFragment;
import com.rock.mvplibrary.base.BaseActivity;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {
    public static final String TAG = HomeActivity.class.getSimpleName();
    private Fragment mShowFragment;
    //双击退出的标志
    private boolean isExit;

    @BindView(R2.id.rg_layout_home_bottom)
    RadioGroup mRadioGroup;
    @BindView(R2.id.cook_rb)
    RadioButton cook;


    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        cook.setChecked(true);
        choiceFragment(CookFragment.TAG);
        mRadioGroup.setOnCheckedChangeListener(this);
    }

    //点击展示对应的Fragment
    private void choiceFragment(String tag) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (mShowFragment != null) {
            ft.hide(mShowFragment);
        }
        mShowFragment = fm.findFragmentByTag(tag);
        if (mShowFragment != null) {
            ft.show(mShowFragment);
        } else {
            try {
                mShowFragment = (Fragment) Class.forName(tag).newInstance();
                ft.add(R.id.main_container, mShowFragment, tag);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        ft.commit();
    }

    //双击退出
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (!isExit) {
            Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
            isExit = true;
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    isExit = false;
                }
            }, 2 * 1000);
        }


        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.cook_rb:
                choiceFragment(CookFragment.TAG);
                break;
            case R.id.food_rb:
                choiceFragment(FoodFragment.TAG);
                break;
            case R.id.message_rb:
                choiceFragment(MessageFragment.TAG);
                break;
            case R.id.mine_rb:
                choiceFragment(MineFragment.TAG);
                break;
        }
    }

    @OnClick(R2.id.post_iv)
    public void postMenuClick(View view){
        Toast.makeText(this, "晒菜谱", Toast.LENGTH_SHORT).show();
    }
}

package com.jaxsen.xianghacaipu.ui.cook.adapter;

/**
 * Created by Administrator on 2017/4/11.
 */

public class SendPosition {
    public  final int WHAT;

    private int position;

    public SendPosition(int what) {
        this.WHAT=what;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}

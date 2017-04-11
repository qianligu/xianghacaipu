package com.jaxsen.xianghacaipu.ui.cook.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/4/11.
 */

public class SearchData {

    /**
     * res : 2
     * data : ["家常菜","早餐","汤","下饭菜","蛋糕","凉菜","川菜","素菜","面食","猪肉","养生","土豆"]
     * append : []
     */

    private int res;
    private List<String> data;

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}

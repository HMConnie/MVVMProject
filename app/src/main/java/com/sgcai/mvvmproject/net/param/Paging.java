package com.sgcai.mvvmproject.net.param;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hinge on 17/5/11.
 */

public class Paging<T> {


    public int pageSize;//分页大小

    public int totalNumber;//数据总条数

    public int pageCount;

    public int curPage;//当前页面

    public String type; // 订单类型

    public List<T> mData; // 加载数据


    public Paging() {
        this.pageSize = 10;
        this.totalNumber = 1;
        this.curPage = 1;
        this.pageCount = 1;
        this.mData = new ArrayList<>();
    }

    public Paging(int pageSize) {
        this.pageSize = pageSize;
        this.totalNumber = 1;
        this.pageCount = 1;
        this.curPage = 1;
        this.mData = new ArrayList<>();
    }

    public Paging(String type) {
        this.type = type;
        this.pageSize = 10;
        this.totalNumber = 1;
        this.pageCount = 1;
        this.curPage = 1;
        this.mData = new ArrayList<>();
    }

    public void reset() {
        this.totalNumber = 1;
        this.curPage = 1;
        this.pageCount = 1;
        this.mData = new ArrayList<>();
    }

    public void success(int recordCnt) {
        this.totalNumber = recordCnt;
        this.pageCount = getPageCount(recordCnt, this.pageSize);
    }

    public void error() {
        this.curPage = this.curPage > 1 ? this.curPage - 1 : 1;
    }

    /**
     * 计算页数
     */
    private int getPageCount(int totalNum, int pageSize) {
        if (totalNum == 0 || pageSize == 0)
            return totalNum;

        int pageCount = totalNum / pageSize;
        if (totalNum % pageSize > 0) {
            pageCount += 1;
        }
        return pageCount;
    }
}

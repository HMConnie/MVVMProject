package com.sgcai.mvvmproject.net.resp;

import cn.connie.mvvm.ex.BaseResponse;

/**
 * Describe:
 * Created by Dalvik on 2019/4/11.
 */
public class ChapterContentBean extends BaseResponse {
    private ChapterContentDataBean data;

    public ChapterContentDataBean getData() {
        return data;
    }

    public void setData(ChapterContentDataBean data) {
        this.data = data;
    }
}

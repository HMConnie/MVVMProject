package com.sgcai.mvvmproject.net.param;

public class LabelListParam extends BaseBenBenParam {
    public int isIndex;//0:首页展示类别，1：发布选择的类别

    public LabelListParam(int isIndex) {
        this.isIndex = isIndex;
    }
}

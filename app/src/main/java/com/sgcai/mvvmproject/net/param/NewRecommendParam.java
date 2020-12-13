package com.sgcai.mvvmproject.net.param;


public class NewRecommendParam extends BaseBenBenParam {
    public int pageNumber;
    public int pageSize;
    public String labelId;
    public int sublabel;//0：最新,1:最热

    public NewRecommendParam(int pageNumber, int pageSize, String labelId, int sublabel) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.labelId = labelId;
        this.sublabel = sublabel;
    }
}

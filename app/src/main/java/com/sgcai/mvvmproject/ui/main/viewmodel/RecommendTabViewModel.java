package com.sgcai.mvvmproject.ui.main.viewmodel;

import com.sgcai.mvvmproject.net.resp.CommunityHomePageRecommendResult;

import androidx.annotation.NonNull;
import cn.connie.mvvm.base.MultiItemViewModel;

public class RecommendTabViewModel extends MultiItemViewModel<HomeRecommendViewModel> {


    public RecommendTabViewModel(@NonNull HomeRecommendViewModel viewModel) {
        super(viewModel);
    }


    public CommunityHomePageRecommendResult.DataBean.ListBean item;

    public RecommendTabViewModel(int multiType, HomeRecommendViewModel viewModel, CommunityHomePageRecommendResult.DataBean.ListBean item) {
        this(viewModel);
        this.multiType = multiType;
        this.item = item;
    }
}

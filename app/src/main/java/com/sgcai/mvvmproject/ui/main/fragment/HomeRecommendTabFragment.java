package com.sgcai.mvvmproject.ui.main.fragment;

import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.sgcai.mvvmproject.BR;
import com.sgcai.mvvmproject.R;
import com.sgcai.mvvmproject.databinding.FragmentBenbenRecommendTabBinding;
import com.sgcai.mvvmproject.net.resp.LabelListResult;
import com.sgcai.mvvmproject.ui.main.viewmodel.HomeRecommendViewModel;

import androidx.lifecycle.Observer;
import cn.connie.mvvm.base.BaseFragment;
import cn.connie.mvvm.utils.MVVMConstants;

public class HomeRecommendTabFragment extends BaseFragment<FragmentBenbenRecommendTabBinding, HomeRecommendViewModel> {
    @Override
    public int getLayout() {
        return R.layout.fragment_benben_recommend_tab;
    }

    @Override
    public void init() {
        LabelListResult.DataBean data = (LabelListResult.DataBean) getArguments().getSerializable(MVVMConstants.BUNDLE);
        viewModel.refreshEvent.observe(this, (Observer<TwinklingRefreshLayout>) o -> {
            viewModel.loadRecommendData(data.labelId, o);
        });
        viewModel.loadMoreEvent.observe(this, (Observer<TwinklingRefreshLayout>) o -> {
            viewModel.loadRecommendData(data.labelId, o);
        });

        viewModel.mPaging.reset();
        viewModel.loadRecommendData(data.labelId, binding.twinklingRefreshLayout);
    }

    @Override
    public int getViewModelId() {
        return BR.viewModel;
    }
}

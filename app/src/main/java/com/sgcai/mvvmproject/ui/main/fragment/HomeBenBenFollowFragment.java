package com.sgcai.mvvmproject.ui.main.fragment;

import com.sgcai.mvvmproject.BR;
import com.sgcai.mvvmproject.R;
import com.sgcai.mvvmproject.databinding.FragmentBenbenFollowBinding;
import com.sgcai.mvvmproject.ui.main.viewmodel.BenBenHomeViewModel;
import com.sgcai.mvvmproject.ui.main.viewmodel.MainViewModel;

import cn.connie.mvvm.base.BaseFragment;

public class HomeBenBenFollowFragment extends BaseFragment<FragmentBenbenFollowBinding, BenBenHomeViewModel> {
    @Override
    public int getLayout() {
        return R.layout.fragment_benben_follow;
    }

    @Override
    public void init() {

    }

    @Override
    public int getViewModelId() {
        return BR.viewModel;
    }
}

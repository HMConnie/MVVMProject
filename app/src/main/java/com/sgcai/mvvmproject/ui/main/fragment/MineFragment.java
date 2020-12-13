package com.sgcai.mvvmproject.ui.main.fragment;

import com.sgcai.mvvmproject.BR;
import com.sgcai.mvvmproject.R;
import com.sgcai.mvvmproject.databinding.FragmentMineBinding;
import com.sgcai.mvvmproject.ui.main.viewmodel.MineViewModel;

import cn.connie.mvvm.base.BaseFragment;

public class MineFragment extends BaseFragment<FragmentMineBinding, MineViewModel> {


    @Override
    public int getLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    public void init() {

    }

    @Override
    public int getViewModelId() {
        return BR.viewModel;
    }
}

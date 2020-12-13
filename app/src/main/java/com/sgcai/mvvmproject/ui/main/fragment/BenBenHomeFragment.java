package com.sgcai.mvvmproject.ui.main.fragment;

import android.graphics.Color;
import android.graphics.Typeface;
import android.widget.TextView;

import com.sgcai.mvvmproject.BR;
import com.sgcai.mvvmproject.R;
import com.sgcai.mvvmproject.databinding.FragmentBenbenHomeBinding;
import com.sgcai.mvvmproject.ui.main.adapter.HomePagerAdapter;
import com.sgcai.mvvmproject.ui.main.viewmodel.BenBenHomeViewModel;

import androidx.lifecycle.Observer;
import cn.connie.mvvm.base.BaseFragment;

public class BenBenHomeFragment extends BaseFragment<FragmentBenbenHomeBinding, BenBenHomeViewModel> {


    @Override
    public int getLayout() {
        return R.layout.fragment_benben_home;
    }

    @Override
    public void init() {
        HomePagerAdapter homePagerAdapter = new HomePagerAdapter(this);
        binding.homeViewPager.setAdapter(homePagerAdapter);
        viewModel.checkTabEvent.observe(this, (Observer<Integer>) o -> {
            binding.tvTitleFollow.setTextColor(Color.parseColor("#afc1bc"));
            binding.tvTitleRecommend.setTextColor(Color.parseColor("#afc1bc"));
            binding.tvTitleFollow.setTypeface(Typeface.DEFAULT, Typeface.NORMAL);
            binding.tvTitleRecommend.setTypeface(Typeface.DEFAULT, Typeface.NORMAL);
            TextView checkTxt = o == 0 ? binding.tvTitleRecommend : binding.tvTitleFollow;
            checkTxt.setTextColor(Color.parseColor("#ff3c53"));
            checkTxt.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            binding.homeViewPager.setCurrentItem(o);
        });

    }

    @Override
    public int getViewModelId() {
        return BR.viewModel;
    }
}

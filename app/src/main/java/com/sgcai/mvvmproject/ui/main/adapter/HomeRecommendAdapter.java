package com.sgcai.mvvmproject.ui.main.adapter;

import android.os.Bundle;

import com.sgcai.mvvmproject.net.resp.LabelListResult;
import com.sgcai.mvvmproject.ui.main.fragment.HomeRecommendTabFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import cn.connie.mvvm.utils.MVVMConstants;

public class HomeRecommendAdapter extends FragmentStatePagerAdapter {


    private List<LabelListResult.DataBean> titleArrays;
    private List<Fragment> fragments;

    public HomeRecommendAdapter(@NonNull FragmentManager fm, List<LabelListResult.DataBean> titleArrays) {
        super(fm);
        this.titleArrays = titleArrays;
        this.fragments = new ArrayList<>();
        for (int i = 0; i < titleArrays.size(); i++) {
            HomeRecommendTabFragment homeRecommendTabFragment = new HomeRecommendTabFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable(MVVMConstants.BUNDLE, titleArrays.get(i));
            homeRecommendTabFragment.setArguments(bundle);
            fragments.add(homeRecommendTabFragment);
        }
    }

    public List<LabelListResult.DataBean> getTitleArrays() {
        return titleArrays;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return titleArrays.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titleArrays.get(position).label;
    }
}

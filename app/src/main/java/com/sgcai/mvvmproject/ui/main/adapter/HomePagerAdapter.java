package com.sgcai.mvvmproject.ui.main.adapter;

import android.view.ViewGroup;

import com.sgcai.mvvmproject.R;
import com.sgcai.mvvmproject.ui.main.fragment.HomeBenBenFollowFragment;
import com.sgcai.mvvmproject.ui.main.fragment.HomeBenBenRecommendFragment;

import java.util.ArrayList;
import java.util.Arrays;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentStatePagerAdapter;
import cn.connie.mvvm.base.BaseFragment;

/**
 * Created by hinge on 18/3/1.
 */

public class HomePagerAdapter extends FragmentStatePagerAdapter {


    private final BaseFragment[] mFragments;
    private final String[] mTitle;
    private BaseFragment mCurrentFragment;

    public BaseFragment getCurrentFragment() {
        return mCurrentFragment;
    }

    public HomePagerAdapter(BaseFragment fragment) {
        super(fragment.getChildFragmentManager());
        this.mFragments = new BaseFragment[]{new HomeBenBenRecommendFragment(), new HomeBenBenFollowFragment()};
        this.mTitle = fragment.getResources().getStringArray(R.array.arr_home_top);
        this.mCurrentFragment = mFragments[0];
    }

    public ArrayList<BaseFragment> getFragments() {
        return new ArrayList<>(Arrays.asList(mFragments));
    }

    @Override
    public void setPrimaryItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.setPrimaryItem(container, position, object);
        mCurrentFragment = (BaseFragment) object;
    }

    public String[] getTitle() {
        return mTitle;
    }

    @Override
    public BaseFragment getItem(int position) {
        return mFragments[position];
    }

    /**
     * 获取推荐页面
     */
    public HomeBenBenRecommendFragment getHomeRecommendFragment() {
        return (HomeBenBenRecommendFragment) mFragments[0];
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle[position];
    }

    /**
     * 不做销毁处理
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }

    /**
     * Fragment个数
     */
    @Override
    public int getCount() {
        return mFragments.length;
    }

}
